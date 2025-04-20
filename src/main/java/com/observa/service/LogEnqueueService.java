package com.observa.service;

import com.observa.model.LogMessage;
import com.observa.queue.LogQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class LogEnqueueService {

    private static final Logger logger = LoggerFactory.getLogger(LogEnqueueService.class);

    @Autowired
    private LogQueue logQueue;


    @Retryable(
            maxAttempts = 3,
            backoff = @Backoff(delay = 100),
            include = {IllegalStateException.class}
    )
    public void enqueueWithRetry(LogMessage logMessage) {
        boolean success = logQueue.enqueue(logMessage);
        if (!success) {
            logger.warn("Queue is full, will retry...");
            throw new IllegalStateException("Queue is full");
        }
    }
}
