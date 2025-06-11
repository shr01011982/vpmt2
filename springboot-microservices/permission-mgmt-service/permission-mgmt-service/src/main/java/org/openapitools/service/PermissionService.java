package org.openapitools.service;

import org.openapitools.entity.Permission;

import java.util.List;

public interface PermissionService {
    Permission save(Permission permission);
    List<Permission> findAll();
    Permission findById(Long id);
    void deleteById(Long id);
}
