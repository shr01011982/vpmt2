package com.stellants.usrmgmt.dto;

import java.util.Set;

public class RolePermissionMappingDTO {
    private String roleName;
    private Set<Long> permissionIds;
    public RolePermissionMappingDTO() {}

    public RolePermissionMappingDTO(String roleName, Set<Long> permissionIds) {
        this.roleName = roleName;
        this.permissionIds = permissionIds;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Long> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(Set<Long> permissionIds) {
        this.permissionIds = permissionIds;
    }
}
