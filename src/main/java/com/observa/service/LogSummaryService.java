package com.observa.service;

import com.observa.model.LogMessage;
import com.observa.storage.InMemoryStorage;
import com.observa.storage.LogStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogSummaryService {

    @Autowired
    private LogStorage storage;

    /**
     * Returns logs from a specific service within the last N minutes
     */
    public List<LogMessage> getLogsByServiceAndMinutes(String service, int minutes) {
        long cutoff = Instant.now().toEpochMilli() - (minutes * 60_000L);

        return storage.getAll().stream()
                .filter(log -> log.getService().equalsIgnoreCase(service))
                .filter(log -> log.getTimestamp() >= cutoff)
                .collect(Collectors.toList());
    }

    public List<LogMessage> getAllLogs() {
        return storage.getAll();
    }
}
