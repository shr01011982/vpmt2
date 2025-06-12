package com.stellants.vdpmt.service.impl;

import com.stellants.vdpmt.entity.Permission;
import com.stellants.vdpmt.entity.Role;
import com.stellants.vdpmt.repository.PermissionRepository;
import com.stellants.vdpmt.repository.RolePermissionService;
import com.stellants.vdpmt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired private PermissionRepository permissionRepository;

    @Override
    public Role mapPermissionsToRole(Long roleId, List<Long> permissionIds) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        List<Permission> permissions = permissionRepository.findAllById(permissionIds);
        role.setPermissions(new HashSet<>(permissions));

        return roleRepository.save(role);
    }

    @Override
    public Set<Permission> getPermissionsByRoleId(Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        return role.getPermissions();
    }
}
