package com.stellants.vdpmt.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException)
            throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", "fail");
        responseBody.put("statusCode", 403);
        responseBody.put("message", "You are not authorized to access this resource");
        responseBody.put("timestamp", LocalDateTime.now().toString());

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), responseBody);
    }
}

