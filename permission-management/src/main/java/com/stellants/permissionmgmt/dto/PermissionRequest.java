package com.stellants.permissionmgmt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PermissionRequest {
    @NotBlank
    @Size(max = 15)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String description;

    public @NotBlank @Size(max = 15) String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(max = 15) String name) {
        this.name = name;
    }

    public @NotBlank @Size(max = 255) String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank @Size(max = 255) String description) {
        this.description = description;
    }
}

