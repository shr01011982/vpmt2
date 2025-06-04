package com.v2soft.vpmt.dto;
import java.util.List;

public class AuthResponse {
    private String token;
    private List<String> permissions;

    public AuthResponse(String token, List<String> permissions) {
        this.token = token;
        this.permissions = permissions;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
