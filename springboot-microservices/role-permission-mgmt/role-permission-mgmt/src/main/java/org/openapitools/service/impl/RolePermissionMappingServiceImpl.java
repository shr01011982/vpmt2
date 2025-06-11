package org.openapitools.service.impl;

import org.openapitools.dto.RolePermissionRequest;
import org.openapitools.dto.RolePermissionResponse;
import org.openapitools.entity.RolePermissionMapping;
import org.openapitools.repository.RolePermissionMappingRepository;
import org.openapitools.service.RolePermissionMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolePermissionMappingServiceImpl implements RolePermissionMappingService {

    @Autowired
    private RolePermissionMappingRepository repository;

    @Override
    public RolePermissionResponse save(RolePermissionRequest request) {
        RolePermissionMapping mapping = new RolePermissionMapping();
        mapping.setRoleName(request.getRoleName());
        mapping.setPermissions(request.getPermissions());
        return toResponse(repository.save(mapping));
    }

    @Override
    public List<RolePermissionResponse> getAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RolePermissionResponse getById(Long id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private RolePermissionResponse toResponse(RolePermissionMapping mapping) {
        RolePermissionResponse res = new RolePermissionResponse();
        res.setId(mapping.getId());
        res.setRoleName(mapping.getRoleName());
        res.setPermissions(mapping.getPermissions());
        return res;
    }
}

