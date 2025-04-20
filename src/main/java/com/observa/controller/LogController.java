package com.observa.controller;

import com.observa.dto.LogRequest;
import com.observa.dto.LogResponse;
import com.observa.model.LogMessage;
import com.observa.queue.LogQueue;
import com.observa.queue.RetryQueue;
import com.observa.service.LogEnqueueService;
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

    @Autowired
    private LogEnqueueService logEnqueueService;

    @Autowired
    private RetryQueue retryQueue;

    @PostMapping
    public ResponseEntity<String> receiveLog(@RequestBody LogRequest request) {
        LogMessage logMessage = new LogMessage();
        logMessage.setService(request.getService());
        logMessage.setLevel(request.getLevel());
        logMessage.setMessage(request.getMessage());
        logMessage.setTimestamp(System.currentTimeMillis());
        try {
            logEnqueueService.enqueueWithRetry(logMessage);
            return ResponseEntity.ok("Log received.");
        } catch (IllegalStateException ex) {
            retryQueue.add(logMessage);
            logger.warn("Log added to retry queue after retry failure: {}", logMessage);
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .body("Temporarily overloaded. Retrying....");
        }
    }

    @GetMapping
    public ResponseEntity<List<LogResponse>> getLogs(@RequestParam(value = "service", required = false) String Service, @RequestParam(value = "level", required = false) String level) {
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
