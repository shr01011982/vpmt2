package com.stellants.vdpmt.controller;

import com.stellants.vdpmt.dto.RoleDTO;
import com.stellants.vdpmt.entity.Role;
import com.stellants.vdpmt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> createRole(@Validated @RequestBody RoleDTO dto) {
        return ResponseEntity.ok(roleService.createRole(dto));
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAll() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }
}

