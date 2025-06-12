package com.stellants.vdpmt.dto;

import jakarta.validation.constraints.NotBlank;

public class RoleDTO {
    @NotBlank(message = "Role name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    public @NotBlank(message = "Role name is required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Role name is required") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Description is required") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Description is required") String description) {
        this.description = description;
    }
}
