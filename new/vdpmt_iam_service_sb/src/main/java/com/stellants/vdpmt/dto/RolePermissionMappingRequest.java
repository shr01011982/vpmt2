package com.stellants.vdpmt.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class RolePermissionMappingRequest {
    @NotNull
    private Long roleId;

    @NotEmpty
    private List<Long> permissionIds;

    public @NotNull Long getRoleId() {
        return roleId;
    }

    public void setRoleId(@NotNull Long roleId) {
        this.roleId = roleId;
    }

    public @NotEmpty List<Long> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(@NotEmpty List<Long> permissionIds) {
        this.permissionIds = permissionIds;
    }
}

