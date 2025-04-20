package com.observa.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Response containing a summary of logs for the past 24 hours.
 */
@Getter
@Setter
public class DailyDigestResponse {
    private String summary;
}
