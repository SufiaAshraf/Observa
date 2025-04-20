package com.observa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogMessage {
    public String Service;
    public String level;
    public String message;
    public long timestamp = System.currentTimeMillis();
}


