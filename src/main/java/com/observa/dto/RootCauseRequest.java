package com.observa.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Request to initiate AI-based root cause analysis for a service over a recent time window.
 */
@Getter
@Setter
public class RootCauseRequest {
    private String service;   // e.g., "inventory-service"
    private int minutes;      // e.g., 60 (analyze logs from the past 60 minutes)
}
