package com.stellants.usrmgmt.service;

import com.stellants.usrmgmt.dto.RoleDTO;
import com.stellants.usrmgmt.dto.RolePermissionMappingDTO;

import java.util.List;

public interface RoleService {
    RoleDTO createRole(RoleDTO dto);
    RoleDTO updateRole(Long id, RoleDTO dto);
    void deleteRole(Long id);
    List<RoleDTO> getAllRoles();
    void mapPermissionsToRole(RolePermissionMappingDTO dto);

}
