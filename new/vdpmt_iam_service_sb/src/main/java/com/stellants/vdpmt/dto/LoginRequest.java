package com.stellants.vdpmt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginRequest {

    @NotBlank(message = "Username is required")
    @NotNull
    private String username;

    @NotBlank(message = "Password is required")
    @NotNull
    private String password;

    public @NotBlank(message = "Username is required") @NotNull String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Username is required") @NotNull String username) {
        this.username = username;
    }

    public @NotBlank(message = "Password is required") @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is required") @NotNull String password) {
        this.password = password;
    }
// Getters and Setters
}
