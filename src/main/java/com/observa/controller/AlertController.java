package com.observa.controller;

import com.observa.dto.AlertRuleRequest;
import com.observa.dto.AlertTriggerResponse;
import com.observa.model.LogMessage;
import com.observa.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @PostMapping("/rules")
    public String addRule(@RequestBody AlertRuleRequest request) {
        alertService.addRule(request);
        return "Alert rule created successfully";
    }

    @GetMapping("/triggered")
    public List<AlertTriggerResponse> getTriggeredAlerts() {
        List<LogMessage> alerts = alertService.getTriggeredAlerts();

        return alerts.stream().map(log -> {
            AlertTriggerResponse res = new AlertTriggerResponse();
            res.setService(log.getService());
            res.setLevel(log.getLevel());
            res.setMessage(log.getMessage());
            res.setTimestamp(log.getTimestamp());
            return res;
        }).toList();
    }
}
