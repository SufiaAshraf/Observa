package com.observa.queue;

import com.observa.model.LogMessage;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static com.observa.util.AppConstants.MAX_RETRY_QUEUE_CAPACITY;

@Component
public class RetryQueue {

    private final BlockingQueue<LogMessage> retryQueue = new LinkedBlockingQueue<>(MAX_RETRY_QUEUE_CAPACITY);

    public void add(LogMessage logMessage) {
        retryQueue.offer(logMessage); // Never blocks
    }

    public LogMessage poll() {
        return retryQueue.poll(); // Returns null if empty
    }

    public int size() {
        return retryQueue.size();
    }
}
