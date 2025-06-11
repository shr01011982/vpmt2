package com.stellants.permissionmgmt.repository;

import com.stellants.permissionmgmt.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {}

