package com.observa.model;

import lombok.*;

import java.util.UUID;

/**
 * Represents an alert rule registered by the user.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertRule {
    private String id = UUID.randomUUID().toString();
    private String service;
    private String level;
    private int threshold;
    private int windowMinutes;

    public AlertRule(String service, String level, int threshold, int windowMinutes) {
        this.id = UUID.randomUUID().toString();
        this.service = service;
        this.level = level;
        this.threshold = threshold;
        this.windowMinutes = windowMinutes;
    }
}
