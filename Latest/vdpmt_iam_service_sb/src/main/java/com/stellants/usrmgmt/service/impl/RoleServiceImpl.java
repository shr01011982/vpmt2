package com.stellants.usrmgmt.service.impl;

import com.stellants.usrmgmt.dto.RoleDTO;
import com.stellants.usrmgmt.dto.RolePermissionMappingDTO;
import com.stellants.usrmgmt.entity.Permission;
import com.stellants.usrmgmt.entity.Role;
import com.stellants.usrmgmt.repository.PermissionRepository;
import com.stellants.usrmgmt.repository.RoleRepository;
import com.stellants.usrmgmt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PermissionRepository permissionRepo;

    @Override
    public RoleDTO createRole(RoleDTO dto) {
        Role role = new Role();
        role.setName(dto.getName());
        role.setDescription(dto.getDescription());
        role = roleRepo.save(role);
        return new RoleDTO(role.getId(), role.getName(), role.getDescription());
    }

    @Override
    public RoleDTO updateRole(Long id, RoleDTO dto) {
        Role role = roleRepo.findById(id).orElseThrow();
        role.setName(dto.getName());
        role.setDescription(dto.getDescription());
        role = roleRepo.save(role);
        return new RoleDTO(role.getId(), role.getName(), role.getDescription());
    }

    @Override
    public void deleteRole(Long id) {
        roleRepo.deleteById(id);
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleRepo.findAll().stream()
                .map(r -> new RoleDTO(r.getId(), r.getName(), r.getDescription()))
                .collect(Collectors.toList());
    }

    @Override
    public void mapPermissionsToRole(RolePermissionMappingDTO dto) {
        Role role = roleRepo.findByName(dto.getRoleName()).orElseThrow();
        Set<Permission> permissions = new HashSet<>(permissionRepo.findAllById(dto.getPermissionIds()));
        role.setPermissions(permissions);
        roleRepo.save(role);
    }
}

