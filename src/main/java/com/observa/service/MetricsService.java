package com.observa.service;

import com.observa.model.LogMessage;
import com.observa.storage.InMemoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MetricsService {

    @Autowired
    private InMemoryStorage storage;

    public List<Map<String, Object>> getMetricsForLast(int minutes) {
        long cutoff = Instant.now().toEpochMilli() - minutes * 60_000L;

        List<LogMessage> logs = storage.getAll().stream()
                .filter(log -> log.getTimestamp() >= cutoff)
                .toList();

        Map<String, Map<String, Integer>> result = new HashMap<>();

        for (LogMessage log : logs) {
            result
                    .computeIfAbsent(log.getService(), k -> new HashMap<>())
                    .merge(log.getLevel(), 1, Integer::sum);
        }

        // Transform to list of maps for controller
        return result.entrySet().stream().map(entry -> {
            Map<String, Object> row = new HashMap<>();
            row.put("service", entry.getKey());
            row.putAll(entry.getValue());
            return row;
        }).collect(Collectors.toList());
    }
}
