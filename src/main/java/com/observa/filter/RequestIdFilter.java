package com.observa.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class RequestIdFilter implements Filter {

    public static final String REQUEST_ID_HEADER = "X-Request-ID";
    private static final Logger logger = LoggerFactory.getLogger(RequestIdFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (request instanceof HttpServletRequest httpRequest && response instanceof HttpServletResponse httpResponse) {

            String requestId = httpRequest.getHeader(REQUEST_ID_HEADER);
            if (requestId == null || requestId.isBlank()) {
                requestId = UUID.randomUUID().toString();
            }

            MDC.put("requestId", requestId);                          // Add to log context
            httpResponse.setHeader(REQUEST_ID_HEADER, requestId);     // Include in response
            request.setAttribute(REQUEST_ID_HEADER, requestId);       // Pass to controller if needed

            String method = httpRequest.getMethod();
            String uri = httpRequest.getRequestURI();
            String query = httpRequest.getQueryString();
            String fullPath = query != null ? uri + "?" + query : uri;
            String ip = httpRequest.getRemoteAddr();
            String ua = httpRequest.getHeader("User-Agent");

            logger.info("→ {} {} | Request-ID: {} | IP: {} | UA: {}", method, fullPath, requestId, ip, ua);
        }

        try {
            chain.doFilter(request, response);
        } finally {
            MDC.remove("requestId"); // Clean up
        }
    }
}
