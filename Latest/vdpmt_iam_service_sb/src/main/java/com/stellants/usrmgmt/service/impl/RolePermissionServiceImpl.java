package com.stellants.usrmgmt.service.impl;

import com.stellants.usrmgmt.dto.RolePermissionDTO;
import com.stellants.usrmgmt.entity.RolePermission;
import com.stellants.usrmgmt.repository.RolePermissionRepository;
import com.stellants.usrmgmt.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionRepository repository;

    @Override
    public RolePermissionDTO create(RolePermissionDTO dto) {
        RolePermission entity = new RolePermission();
        entity.setRoleId(dto.getRoleId());
        entity.setPermissionId(dto.getPermissionId());
        entity.setName("Role " + dto.getRoleId() + " - Permission " + dto.getPermissionId());
        entity = repository.save(entity);
        return new RolePermissionDTO(entity.getId(), entity.getRoleId(), entity.getPermissionId(), entity.getName());
    }

    @Override
    public RolePermissionDTO update(Long id, RolePermissionDTO dto) {
        RolePermission entity = repository.findById(id).orElseThrow();
        entity.setRoleId(dto.getRoleId());
        entity.setPermissionId(dto.getPermissionId());
        entity.setName("Role " + dto.getRoleId() + " - Permission " + dto.getPermissionId());
        entity = repository.save(entity);
        return new RolePermissionDTO(entity.getId(), entity.getRoleId(), entity.getPermissionId(), entity.getName());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<RolePermissionDTO> getAll() {
        return repository.findAll().stream()
                .map(r -> new RolePermissionDTO(r.getId(), r.getRoleId(), r.getPermissionId(), r.getName()))
                .collect(Collectors.toList());
    }
}
