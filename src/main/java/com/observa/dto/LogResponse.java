package com.observa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogResponse {
    private String service;
    private String level;
    private String message;
    private long timestamp;
}
