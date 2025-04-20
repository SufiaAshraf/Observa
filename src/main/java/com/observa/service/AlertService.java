package com.observa.service;

import com.observa.dto.AlertRuleRequest;
import com.observa.model.AlertRule;
import com.observa.model.LogMessage;
import com.observa.storage.LogStorage;
import com.observa.storage.TriggeredAlertStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Handles alert rule registration and evaluation logic.
 */
@Service
public class AlertService {

    private final List<AlertRule> rules = new CopyOnWriteArrayList<>();

    @Autowired
    private LogStorage logStorage;

    @Autowired
    private TriggeredAlertStore triggeredAlertStore;

    // Add a new alert rule from client request
    public void addRule(AlertRuleRequest request) {
        AlertRule rule = new AlertRule();
        rule.setService(request.getService());
        rule.setLevel(request.getLevel());
        rule.setThreshold(request.getThreshold());
        rule.setWindowMinutes(request.getWindowMinutes());
        rules.add(rule);
    }

    // Get all active alert rules
    public List<AlertRule> getRules() {
        return List.copyOf(rules);
    }

    // Evaluate all rules against recent logs
    public void evaluateRules() {
        long now = Instant.now().toEpochMilli();

        for (AlertRule rule : rules) {
            long cutoff = now - rule.getWindowMinutes() * 60_000L;

            List<LogMessage> recentLogs = logStorage.getAll().stream()
                    .filter(log -> log.getTimestamp() >= cutoff)
                    .filter(log -> log.getService().equalsIgnoreCase(rule.getService()))
                    .filter(log -> log.getLevel().equalsIgnoreCase(rule.getLevel()))
                    .toList();

            if (recentLogs.size() >= rule.getThreshold()) {
                LogMessage alert = new LogMessage();
                alert.setService(rule.getService());
                alert.setLevel(rule.getLevel());
                alert.setMessage("Triggered: " + recentLogs.size() + " logs in " + rule.getWindowMinutes() + " minutes");
                alert.setTimestamp(now);
                triggeredAlertStore.add(alert);
            }
        }
    }

    // Return logs that triggered alerts
    public List<LogMessage> getTriggeredAlerts() {
        return triggeredAlertStore.getAll();
    }
}
