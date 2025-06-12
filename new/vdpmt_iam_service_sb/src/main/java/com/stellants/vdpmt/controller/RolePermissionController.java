package com.stellants.vdpmt.controller;

import com.stellants.vdpmt.dto.ApiResponse;
import com.stellants.vdpmt.dto.RolePermissionMappingRequest;
import com.stellants.vdpmt.entity.Permission;
import com.stellants.vdpmt.entity.Role;
import com.stellants.vdpmt.repository.RolePermissionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/role-permissions")
public class RolePermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    @PostMapping("/assign")
    public ResponseEntity<ApiResponse<Role>> assignPermissionsToRole(
            @Valid @RequestBody RolePermissionMappingRequest request) {

        Role updatedRole = rolePermissionService.mapPermissionsToRole(request.getRoleId(), request.getPermissionIds());

        ApiResponse<Role> response = new ApiResponse<>();
        response.setStatus("success");
        response.setStatusCode(200);
        response.setMessage("Permissions assigned to role successfully");
        response.setResult(updatedRole);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{roleId}/permissions")
    public ResponseEntity<ApiResponse<Set<Permission>>> getPermissionsForRole(@PathVariable Long roleId) {
        Set<Permission> permissions = rolePermissionService.getPermissionsByRoleId(roleId);

        ApiResponse<Set<Permission>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setStatusCode(200);
        response.setMessage("Permissions retrieved for the role");
        response.setResult(permissions);

        return ResponseEntity.ok(response);
    }
}
