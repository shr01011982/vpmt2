package com.stellants.vdpmt.repository;

import com.stellants.vdpmt.entity.Permission;
import com.stellants.vdpmt.entity.Role;

import java.util.List;
import java.util.Set;

public interface RolePermissionService {
    Role mapPermissionsToRole(Long roleId, List<Long> permissionIds);
    Set<Permission> getPermissionsByRoleId(Long roleId);
}

