package com.stellants.usrmgmt.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "role_permission_mapping")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name = "permission_id", nullable = false)
    private Long permissionId;

    @Column(nullable = false, length = 100)
    private String name;

    public RolePermission() {}

    public RolePermission(Long id, Long roleId, Long permissionId, String name) {
        this.id = id;
        this.roleId = roleId;
        this.permissionId = permissionId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public void setName(String name) {
        this.name = name;
    }
}

