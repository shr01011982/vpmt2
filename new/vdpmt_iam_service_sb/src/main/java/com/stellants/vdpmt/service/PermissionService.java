package com.stellants.vdpmt.service;

import com.stellants.vdpmt.dto.PermissionDTO;
import com.stellants.vdpmt.entity.Permission;

import java.util.List;

public interface PermissionService {
    Permission  createPermission(PermissionDTO dto);
    List<Permission> getAllPermissions();

}
