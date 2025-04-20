package com.observa.service;

import com.observa.dto.AIAnalysisRequest;
import com.observa.dto.AIAnalysisResponse;
import com.observa.util.PromptLoader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LogAIService {

    @Value("${ai.model.url}")
    private String modelUrl;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final RestTemplate restTemplate = new RestTemplate();

    public AIAnalysisResponse analyzeLog(AIAnalysisRequest request) {
        String promptTemplate = PromptLoader.load("SingleLogPrompt.txt");
        String prompt = String.format(promptTemplate, request.getMessage());

        Map<String, Object> payload = new HashMap<>();
        payload.put("model", "mistral");
        payload.put("prompt", prompt);
        payload.put("stream", false);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(modelUrl, entity, String.class);

        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            String aiJson = root.path("response").asText();
            JsonNode ai = objectMapper.readTree(aiJson);

            AIAnalysisResponse result = new AIAnalysisResponse();
            result.setClassification(ai.path("classification").asText());
            result.setSummary(ai.path("summary").asText());
            result.setAnomalous(ai.path("anomalous").asBoolean());

            return result;

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse AI response", e);
        }
    }
}
