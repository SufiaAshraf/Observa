package com.observa.controller;

import com.observa.dto.*;
import com.observa.model.LogMessage;
import com.observa.service.LogAIService;
import com.observa.service.LogSummaryService;
import com.observa.util.PromptLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class AIController {

    @Autowired
    private LogAIService logAIService;

    @Autowired
    private LogSummaryService logSummaryService;

    @PostMapping("/ai-analyze")
    public AIAnalysisResponse analyzeLog(@RequestBody AIAnalysisRequest request) {
        return logAIService.analyzeLog(request);
    }

    @GetMapping("/summary")
    public AISummaryResponse summarizeLogs(
            @RequestParam String service,
            @RequestParam(defaultValue = "10") int minutes) {

        List<LogMessage> logs = logSummaryService.getLogsByServiceAndMinutes(service, minutes);

        StringBuilder input = new StringBuilder();
        logs.forEach(log -> input.append("- ").append(log.getMessage()).append("\n"));

        String promptTemplate = PromptLoader.load("SummaryPrompt.txt");
        String prompt = String.format(promptTemplate, service, input);

        AIAnalysisRequest request = new AIAnalysisRequest();
        request.setMessage(prompt);

        AIAnalysisResponse ai = logAIService.analyzeLog(request);

        AISummaryResponse response = new AISummaryResponse();
        response.setSummary(ai.getSummary());
        return response;
    }

    @PostMapping("/query-ai")
    public AIQueryResponse queryLogs(@RequestBody AIQueryRequest queryRequest) {
        List<LogMessage> allLogs = logSummaryService.getAllLogs();

        StringBuilder context = new StringBuilder();
        allLogs.forEach(log -> context.append("- ").append(log.getMessage()).append("\n"));

        String promptTemplate = PromptLoader.load("QueryPrompt.txt");
        String fullPrompt = String.format(promptTemplate, context, queryRequest.getQuestion());

        AIAnalysisRequest request = new AIAnalysisRequest();
        request.setMessage(fullPrompt);

        AIAnalysisResponse ai = logAIService.analyzeLog(request);

        AIQueryResponse response = new AIQueryResponse();
        response.setAnswer(ai.getSummary()); // reuse summary as answer
        return response;
    }
}
