package org.openapitools.service;


import org.openapitools.dto.RolePermissionRequest;
import org.openapitools.dto.RolePermissionResponse;

import java.util.List;

public interface RolePermissionMappingService {
    RolePermissionResponse save(RolePermissionRequest request);
    List<RolePermissionResponse> getAll();
    RolePermissionResponse getById(Long id);
    void deleteById(Long id);
}
