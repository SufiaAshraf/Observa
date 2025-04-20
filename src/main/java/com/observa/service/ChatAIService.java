package com.observa.service;

import com.observa.dto.ChatQueryRequest;
import com.observa.dto.ChatQueryResponse;
import com.observa.model.LogMessage;
import com.observa.storage.LogStorage;
import com.observa.util.PromptLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Instant;
import java.util.List;

@Service
public class ChatAIService {

    @Value("${ai.model.url}")
    private String modelUrl;

    @Autowired
    private LogStorage storage;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final RestTemplate restTemplate = new RestTemplate();

    public ChatQueryResponse chatWithLogs(ChatQueryRequest request) {
        long cutoff = Instant.now().toEpochMilli() - (request.getMinutes() != null ? request.getMinutes() * 60_000L : 60 * 60_000L);

        List<LogMessage> logs = storage.getAll().stream()
                .filter(log -> log.getTimestamp() >= cutoff)
                .filter(log -> request.getService() == null || log.getService().equalsIgnoreCase(request.getService()))
                .toList();

        StringBuilder context = new StringBuilder();
        logs.forEach(log -> context.append("- ").append(log.getMessage()).append("\n"));

        String promptTemplate = PromptLoader.load("QueryPrompt.txt");
        String prompt = String.format(promptTemplate, context, request.getQuestion());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> entity = new HttpEntity<>(new PromptPayload(prompt), headers);
        ResponseEntity<String> response = restTemplate.postForEntity(modelUrl, entity, String.class);

        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            String reply = root.path("response").asText();
            ChatQueryResponse chatResponse = new ChatQueryResponse();
            chatResponse.setAnswer(reply);
            return chatResponse;
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse AI response", e);
        }
    }

    private record PromptPayload(String prompt) {
        public String getModel() {
            return "mistral";
        }

        public boolean isStream() {
            return false;
        }
    }
}
