package com.observa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatQueryRequest {
    private String question;
    private String service; // Optional
    private Integer minutes; // Optional — logs from past N minutes
}
