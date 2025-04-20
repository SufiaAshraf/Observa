package com.observa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AIAnalysisResponse {
    private String classification;
    private String summary;
    private boolean anomalous;
}
