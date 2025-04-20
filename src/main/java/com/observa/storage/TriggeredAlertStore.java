package com.observa.storage;

import com.observa.model.LogMessage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * In-memory storage for logs that triggered alert rules.
 */
@Component
public class TriggeredAlertStore {

    private final List<LogMessage> triggeredAlerts = new CopyOnWriteArrayList<>();

    public void add(LogMessage alertLog) {
        triggeredAlerts.add(alertLog);
    }

    public List<LogMessage> getAll() {
        return List.copyOf(triggeredAlerts);
    }

    public void clear() {
        triggeredAlerts.clear();
    }
}
