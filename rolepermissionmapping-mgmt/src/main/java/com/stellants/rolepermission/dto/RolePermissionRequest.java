package com.stellants.rolepermission.dto;
import jakarta.validation.constraints.*;
import java.util.Set;
public class RolePermissionRequest {
@NotBlank
@Size(max = 15)
private String roleName;

@NotEmpty
private Set<@Pattern(regexp = "CREATE|READ|UPDATE|DELETE") String> permissions;

// Getters and Setters
public String getRoleName() { return roleName; }
public void setRoleName(String roleName) { this.roleName = roleName; }

public Set<String> getPermissions() { return permissions; }
public void setPermissions(Set<String> permissions) { this.permissions = permissions; }

}

