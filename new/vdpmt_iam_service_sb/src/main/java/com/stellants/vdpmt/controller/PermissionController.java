package com.stellants.vdpmt.controller;

import com.stellants.vdpmt.dto.ApiResponse;
import com.stellants.vdpmt.dto.PermissionDTO;
import com.stellants.vdpmt.entity.Permission;
import com.stellants.vdpmt.service.PermissionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping
    public ResponseEntity<ApiResponse<Permission>> createPermission(@Valid @RequestBody PermissionDTO dto) {
        Permission saved = permissionService.createPermission(dto);

        ApiResponse<Permission> response = new ApiResponse<>();
        response.setStatus("success");
        response.setStatusCode(200);
        response.setMessage("Permission added successfully");
        response.setResult(saved);

        return ResponseEntity.ok(response);
    }

//    @GetMapping
//    public ResponseEntity<List<Permission>> getAll() {
//        return ResponseEntity.ok(permissionService.getAllPermissions());
//    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Permission>>> getAllPermissions() {
        List<Permission> permissions = permissionService.getAllPermissions();

        ApiResponse<List<Permission>> response = new ApiResponse<>();
        response.setStatus("success");
        response.setStatusCode(200);
        response.setMessage("Permissions Listing");
        response.setResult(permissions);

        return ResponseEntity.ok(response);
    }
}

