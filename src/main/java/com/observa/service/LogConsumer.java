package com.observa.service;

import com.observa.model.LogMessage;
import com.observa.queue.LogQueue;
import com.observa.storage.LogStorage;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogConsumer {
    private static final Logger logger = LoggerFactory.getLogger(LogConsumer.class);

    @Autowired
    private LogQueue logQueue;

    @Autowired
    private LogStorage logStorage;

    @PostConstruct
    public void startConsumer() throws InterruptedException {
        Thread consumerThread = new Thread(() -> {
            while (true) {
                try{
                    LogMessage logMessage = logQueue.dequeue();
                    logStorage.store(logMessage);
                    logger.info("Stored log: {}, {}", logMessage.getId(), logMessage.getMessage());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Consumer thread interrupted");
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        consumerThread.setDaemon(true); // allows JVM to shut down if only this thread is running
        consumerThread.start();
    }
}
