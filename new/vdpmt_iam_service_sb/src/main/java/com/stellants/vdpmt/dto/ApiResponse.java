package com.stellants.vdpmt.dto;

import jakarta.persistence.Table;

public class ApiResponse<T> {
    private String status;
    private int statusCode;
    private String message;
    private T result;
    public ApiResponse() {}
    public ApiResponse(String status, int statusCode, String message, T result) {
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
        this.result = result;
    }

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
