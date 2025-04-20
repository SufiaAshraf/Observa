package com.observa.controller;

import com.observa.dto.DailyDigestResponse;
import com.observa.service.DailyDigestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs/daily-digest")
public class DailyDigestController {

    @Autowired
    private DailyDigestService digestService;

    @GetMapping
    public DailyDigestResponse getDigest() {
        return digestService.generate();
    }
}
