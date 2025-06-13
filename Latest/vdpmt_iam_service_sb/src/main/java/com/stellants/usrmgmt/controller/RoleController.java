package com.stellants.usrmgmt.controller;

import com.stellants.usrmgmt.dto.RoleDTO;
import com.stellants.usrmgmt.dto.RolePermissionMappingDTO;
import com.stellants.usrmgmt.response.ApiResponse;
import com.stellants.usrmgmt.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@Tag(name = "Role Management")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    @Operation(summary = "Create a role")
    public ResponseEntity<ApiResponse<RoleDTO>> create(@RequestBody RoleDTO dto) {
        RoleDTO result = roleService.createRole(dto);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Role added suceessfully", result));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a role")
    public ResponseEntity<ApiResponse<RoleDTO>> update(@PathVariable Long id, @RequestBody RoleDTO dto) {
        RoleDTO result = roleService.updateRole(id, dto);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Role updated suceessfully", result));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a role")
    public ResponseEntity<ApiResponse<List<Object>>> delete(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Role deleted suceessfully", List.of()));
    }

    @GetMapping
    @Operation(summary = "List all roles")
    public ResponseEntity<ApiResponse<List<RoleDTO>>> getAll() {
        List<RoleDTO> roles = roleService.getAllRoles();
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Roles Listing", roles));
    }

    @PostMapping("/map-to-permissions")
    @Operation(summary = "Map permissions to role")
    public ResponseEntity<ApiResponse<List<Object>>> mapToPermissions(@RequestBody RolePermissionMappingDTO dto) {
        roleService.mapPermissionsToRole(dto);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Permissions mapped to role", List.of()));
    }
}

