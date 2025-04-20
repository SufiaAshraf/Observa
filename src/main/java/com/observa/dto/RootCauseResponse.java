package com.observa.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Response returned after analyzing logs for possible root cause.
 */
@Getter
@Setter
public class RootCauseResponse {
    private String rootCause;
}
