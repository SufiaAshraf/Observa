package com.observa.controller;

import com.observa.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/logs/metrics")
public class MetricsController {

    @Autowired
    private MetricsService metricsService;

    @GetMapping
    public List<Map<String, Object>> getMetrics(@RequestParam(defaultValue = "60") int minutes) {
        return metricsService.getMetricsForLast(minutes);
    }
}
