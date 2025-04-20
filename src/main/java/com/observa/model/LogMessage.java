package com.observa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogMessage {
    private final String id = UUID.randomUUID().toString();
    public String Service;
    public String level;
    public String message;
    public long timestamp = System.currentTimeMillis();
}


