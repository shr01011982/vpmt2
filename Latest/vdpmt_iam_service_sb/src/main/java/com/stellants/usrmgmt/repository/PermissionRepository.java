package com.stellants.usrmgmt.repository;

import com.stellants.usrmgmt.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
