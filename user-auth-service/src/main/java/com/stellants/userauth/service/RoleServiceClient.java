package com.stellants.userauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class RoleServiceClient {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private static final String ROLE_SERVICE_URL = "http://localhost:8082/api/role-permissions";

    public List<String> fetchAvailableRoles() {
        return webClientBuilder.build()
                .get()
                .uri(ROLE_SERVICE_URL)
                .retrieve()
                .bodyToFlux(String.class) // or use a wrapper DTO if needed
                .collectList()
                .block();
    }
}

