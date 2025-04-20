package com.observa.service;

import com.observa.dto.DailyDigestResponse;
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
public class DailyDigestService {

    private final LogStorage storage;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${ai.model.url}")
    private String modelUrl;

    public DailyDigestService(LogStorage storage) {
        this.storage = storage;
    }

    public DailyDigestResponse generate() {
        long cutoff = Instant.now().toEpochMilli() - 24 * 60 * 60 * 1000L;

        List<LogMessage> recentLogs = storage.getAll().stream()
                .filter(log -> log.getTimestamp() >= cutoff)
                .toList();

        StringBuilder logContext = new StringBuilder();
        recentLogs.forEach(log -> logContext.append("- [")
                .append(log.getService()).append("] ")
                .append(log.getMessage()).append("\n"));

        String promptTemplate = PromptLoader.load("DailyDigestPrompt.txt");
        String prompt = String.format(promptTemplate, logContext);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> entity = new HttpEntity<>(new PromptPayload(prompt), headers);
        ResponseEntity<String> response = restTemplate.postForEntity(modelUrl, entity, String.class);

        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            String reply = root.path("response").asText();
            DailyDigestResponse result = new DailyDigestResponse();
            result.setSummary(reply);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse daily digest response", e);
        }
    }

    private record PromptPayload(String prompt) {
        public String getModel() { return "mistral"; }
        public boolean isStream() { return false; }
    }
}
