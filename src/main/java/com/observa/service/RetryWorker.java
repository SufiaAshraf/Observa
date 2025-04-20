package com.observa.service;

import com.observa.model.LogMessage;
import com.observa.queue.LogQueue;
import com.observa.queue.RetryQueue;
import com.observa.util.AppConstants;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RetryWorker {

    private static final Logger logger = LoggerFactory.getLogger(RetryWorker.class);

    @Autowired
    private RetryQueue retryQueue;

    @Autowired
    private LogQueue logQueue;

    @PostConstruct
    public void startWorker() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    LogMessage log = retryQueue.poll();
                    if (log != null) {
                        boolean success = logQueue.enqueue(log);
                        if (!success) {
                            logger.warn("Retry failed again, re-queueing: {}", log);
                            retryQueue.add(log); // Put it back
                        } else {
                            logger.info("Successfully retried log: {}", log);
                        }
                    }

                    Thread.sleep(AppConstants.RETRY_WORKER_INTERVAL_MS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                } catch (Exception e) {
                    logger.error("Unexpected error in RetryWorker", e);
                }
            }
        });

        thread.setDaemon(true);
        thread.start();
    }
}
