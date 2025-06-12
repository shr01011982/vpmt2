package com.stellants.vdpmt.repository;

import com.stellants.vdpmt.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    boolean existsByName(String name);
}
