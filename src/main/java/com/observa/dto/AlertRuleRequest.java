package com.observa.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO to accept a user-defined alert rule.
 */
@Getter
@Setter
public class AlertRuleRequest {
    private String service;
    private String level;
    private int threshold;
    private int windowMinutes;
}
