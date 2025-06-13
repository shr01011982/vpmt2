package com.stellants.usrmgmt.service;



import com.stellants.usrmgmt.dto.RolePermissionDTO;

import java.util.List;

public interface RolePermissionService {
    RolePermissionDTO create(RolePermissionDTO dto);
    RolePermissionDTO update(Long id, RolePermissionDTO dto);
    void delete(Long id);
    List<RolePermissionDTO> getAll();
}

