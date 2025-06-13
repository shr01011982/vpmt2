package com.stellants.usrmgmt.controller;

import com.stellants.usrmgmt.dto.RolePermissionDTO;
import com.stellants.usrmgmt.response.ApiResponse;
import com.stellants.usrmgmt.service.RolePermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role-permissions")
@Tag(name = "Role to Permission Mapping")
public class RolePermissionController {

    @Autowired
    private RolePermissionService service;

    @GetMapping
    @Operation(summary = "Get all Role to Permission mappings")
    public ResponseEntity<ApiResponse<List<RolePermissionDTO>>> getAll() {
        List<RolePermissionDTO> list = service.getAll();
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Permissions Listing", list));
    }

    @PostMapping
    @Operation(summary = "Create Role to Permission mapping")
    public ResponseEntity<ApiResponse<RolePermissionDTO>> create(@RequestBody RolePermissionDTO dto) {
        RolePermissionDTO result = service.create(dto);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Role to Permission added suceessfully", result));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Role to Permission mapping")
    public ResponseEntity<ApiResponse<RolePermissionDTO>> update(@PathVariable Long id, @RequestBody RolePermissionDTO dto) {
        RolePermissionDTO result = service.update(id, dto);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Role to Permission updated suceessfully", result));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Role to Permission mapping")
    public ResponseEntity<ApiResponse<List<Object>>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(new ApiResponse<>("success", 200, "Role to Permission deleted suceessfully", List.of()));
    }
}

