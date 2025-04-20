package com.observa.controller;

import com.observa.dto.LogRequest;
import com.observa.dto.LogResponse;
import com.observa.model.LogMessage;
import com.observa.queue.LogQueue;
import com.observa.storage.LogStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @Autowired
    private LogQueue logQueue;

    @Autowired
    private LogStorage logStorage;

    @PostMapping
    public ResponseEntity<String> receiveLog(@RequestBody LogRequest request) {
        LogMessage logMessage = new LogMessage();
        logMessage.setService(request.getService());
        logMessage.setLevel(request.getLevel());
        logMessage.setMessage(request.getMessage());
        logMessage.setTimestamp(System.currentTimeMillis());

        boolean success = logQueue.enqueue(logMessage);
        if (!success) {
            logger.warn("Rejected log message {}", logMessage);
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Too Many Request.Try Again later");
        }
        logger.debug("Log enqueued for processing: {}", logMessage);
        return ResponseEntity.ok("Log enqueued for processing");
    }

    @GetMapping
    public ResponseEntity<List<LogResponse>> getLogs(@RequestParam(required = false) String Service, @RequestParam(required = false) String level) {
        List<LogMessage> logs = logStorage.getFiltered(Service, level);
        logger.debug("Returned {} log(s) for service='{}' level='{}'", logs.size(), Service, level);
        // Convert LogMessage → LogResponse
        List<LogResponse> response = logs.stream()
                .map(log -> new LogResponse(
                        log.getService(),
                        log.getLevel(),
                        log.getMessage(),
                        log.getTimestamp()
                ))
                .toList();

        return ResponseEntity.ok(response);
    }
}
