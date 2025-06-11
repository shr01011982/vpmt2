package com.stellants.rolepermission.controller;


import com.stellants.rolepermission.dto.PermissionDto;
import com.stellants.rolepermission.dto.RolePermissionRequest;
import com.stellants.rolepermission.dto.RolePermissionResponse;
import com.stellants.rolepermission.service.RolePermissionMappingService;
import com.stellants.rolepermission.service.external.PermissionServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/role-permissions")
public class RolePermissionMappingController {

    @Autowired
    private RolePermissionMappingService service;

    @Autowired
    private PermissionServiceClient permissionServiceClient;

    @PostMapping
    public ResponseEntity<RolePermissionResponse> create(@Valid @RequestBody RolePermissionRequest request) {
        return new ResponseEntity<>(service.save(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RolePermissionResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<RolePermissionResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping("/available-permissions")
    public ResponseEntity<List<PermissionDto>> getAvailablePermissions() {
        return ResponseEntity.ok(permissionServiceClient.getAllPermissions());
    }
//with constructor injection (preferred)
//    private final PermissionServiceClient permissionServiceClient;
//
//    public RolePermissionMappingController(PermissionServiceClient permissionServiceClient) {
//        this.permissionServiceClient = permissionServiceClient;
//    }

}

