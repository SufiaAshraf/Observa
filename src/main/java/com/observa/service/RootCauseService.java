package com.observa.service;

import com.observa.dto.RootCauseRequest;
import com.observa.dto.RootCauseResponse;
import com.observa.model.LogMessage;
import com.observa.storage.LogStorage;
import com.observa.util.PromptLoader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.List;

@Service
public class RootCauseService {

    private final LogStorage storage;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${ai.model.url}")
    private String modelUrl;

    public RootCauseService(LogStorage storage) {
        this.storage = storage;
    }

    public RootCauseResponse analyze(RootCauseRequest request) {
        long cutoff = Instant.now().toEpochMilli() - request.getMinutes() * 60_000L;

        List<LogMessage> filteredLogs = storage.getAll().stream()
                .filter(log -> log.getTimestamp() >= cutoff)
                .filter(log -> log.getService().equalsIgnoreCase(request.getService()))
                .toList();

        StringBuilder logContext = new StringBuilder();
        filteredLogs.forEach(log -> logContext.append("- ").append(log.getMessage()).append("\n"));

        String promptTemplate = PromptLoader.load("RootCausePrompt.txt");
        String prompt = String.format(promptTemplate, request.getService(), request.getMinutes(), logContext);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> entity = new HttpEntity<>(new PromptPayload(prompt), headers);
        ResponseEntity<String> response = restTemplate.postForEntity(modelUrl, entity, String.class);

        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            String reply = root.path("response").asText();
            RootCauseResponse result = new RootCauseResponse();
            result.setRootCause(reply);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse root cause AI response", e);
        }
    }

    private record PromptPayload(String prompt) {
        public String getModel() { return "mistral"; }
        public boolean isStream() { return false; }
    }
}
