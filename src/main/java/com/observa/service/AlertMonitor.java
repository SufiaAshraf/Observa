package com.observa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Periodically checks all alert rules against recent logs.
 */
@Component
public class AlertMonitor {

    @Autowired
    private AlertService alertService;

    // Every 60 seconds
    @Scheduled(fixedRate = 60_000)
    public void monitorAlerts() {
        alertService.evaluateRules();
    }
}
