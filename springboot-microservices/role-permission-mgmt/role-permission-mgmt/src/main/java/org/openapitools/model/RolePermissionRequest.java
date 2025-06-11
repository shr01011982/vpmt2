package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * RolePermissionRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-11T09:32:45.327152400+05:30[Asia/Calcutta]", comments = "Generator version: 7.13.0")
public class RolePermissionRequest {

  private String roleName;

  /**
   * Gets or Sets permissions
   */
  public enum PermissionsEnum {
    CREATE("CREATE"),
    
    READ("READ"),
    
    UPDATE("UPDATE"),
    
    DELETE("DELETE");

    private final String value;

    PermissionsEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PermissionsEnum fromValue(String value) {
      for (PermissionsEnum b : PermissionsEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @Valid
  private List<PermissionsEnum> permissions = new ArrayList<>();

  public RolePermissionRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RolePermissionRequest(String roleName, List<PermissionsEnum> permissions) {
    this.roleName = roleName;
    this.permissions = permissions;
  }

  public RolePermissionRequest roleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  /**
   * Get roleName
   * @return roleName
   */
  @NotNull @Size(max = 15) 
  @Schema(name = "roleName", example = "ADMIN", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("roleName")
  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public RolePermissionRequest permissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
    return this;
  }

  public RolePermissionRequest addPermissionsItem(PermissionsEnum permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * Get permissions
   * @return permissions
   */
  @NotNull 
  @Schema(name = "permissions", example = "[\"CREATE\",\"UPDATE\"]", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("permissions")
  public List<PermissionsEnum> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<PermissionsEnum> permissions) {
    this.permissions = permissions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RolePermissionRequest rolePermissionRequest = (RolePermissionRequest) o;
    return Objects.equals(this.roleName, rolePermissionRequest.roleName) &&
        Objects.equals(this.permissions, rolePermissionRequest.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleName, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RolePermissionRequest {\n");
    sb.append("    roleName: ").append(toIndentedString(roleName)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

