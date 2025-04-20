package com.observa.dto;

import lombok.Data;

@Data
public class LogRequest {
    private String service;
    private String message;
    private String level;
}
