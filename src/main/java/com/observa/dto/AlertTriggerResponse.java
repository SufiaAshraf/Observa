package com.observa.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO to return a fired alert's details.
 */
@Getter
@Setter
public class AlertTriggerResponse {
    private String service;
    private String level;
    private String message;
    private long timestamp;
}
