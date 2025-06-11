package org.openapitools.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role_permission_mappings")
public class RolePermissionMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false)
    private String roleName;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "role_permission_entries", joinColumns = @JoinColumn(name = "mapping_id"))
    @Column(name = "permission")
    private Set<String> permissions;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }

    public Set<String> getPermissions() { return permissions; }
    public void setPermissions(Set<String> permissions) { this.permissions = permissions; }
}

// RolePermissionMappingRepository.java

