package com.stellants.vdpmt.dto;

public class AuthResponse {
    private String status;
    private int statusCode;
    private String message;
    private String token;
    private UserDTO result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDTO getResult() {
        return result;
    }

    public void setResult(UserDTO result) {
        this.result = result;
    }
}
