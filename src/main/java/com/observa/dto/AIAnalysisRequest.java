package com.observa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AIAnalysisRequest {
    private String service;
    private String level;
    private String message;
}
