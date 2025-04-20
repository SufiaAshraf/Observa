package com.observa.controller;

import com.observa.dto.ChatQueryRequest;
import com.observa.dto.ChatQueryResponse;
import com.observa.service.ChatAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs/chat")
public class ChatController {

    @Autowired
    private ChatAIService chatAIService;

    @PostMapping
    public ChatQueryResponse chatWithLogs(@RequestBody ChatQueryRequest request) {
        return chatAIService.chatWithLogs(request);
    }
}
