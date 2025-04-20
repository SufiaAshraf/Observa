package com.observa.storage;

import com.observa.model.LogMessage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InMemoryStorage implements LogStorage {
    private final List<LogMessage> logStore = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void store(LogMessage log) {
        logStore.add(log);
    }

    @Override
    public List<LogMessage> getAll() {
        return new ArrayList<>(logStore);  // Return a copy to avoid concurrency issues
    }

    @Override
    public List<LogMessage> getAllByService(String Service) {
        return logStore.stream()
                .filter(log -> log.getService().equalsIgnoreCase(Service))
                .collect(Collectors.toList());
    }

    @Override
    public List<LogMessage> getAllByLevel(String level) {
        return logStore.stream()
                .filter(log -> log.getLevel().equalsIgnoreCase(level))
                .collect(Collectors.toList());
    }

    @Override
    public List<LogMessage> getFiltered(String Service, String level) {
        return logStore.stream()
                .filter(log ->
                        (Service == null || log.getService().equalsIgnoreCase(Service)) &&
                                (level == null || log.getLevel().equalsIgnoreCase(level))
                )
                .collect(Collectors.toList());
    }

}
