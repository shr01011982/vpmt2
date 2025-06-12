package com.stellants.vdpmt.dto;

import jakarta.validation.constraints.NotBlank;

public class PermissionDTO {
    @NotBlank(message = "Permission name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
