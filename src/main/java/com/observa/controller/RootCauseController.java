package com.observa.controller;

import com.observa.dto.RootCauseRequest;
import com.observa.dto.RootCauseResponse;
import com.observa.service.RootCauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs/root-cause")
public class RootCauseController {

    @Autowired
    private RootCauseService rootCauseService;

    @PostMapping
    public RootCauseResponse analyze(@RequestBody RootCauseRequest request) {
        return rootCauseService.analyze(request);
    }
}
