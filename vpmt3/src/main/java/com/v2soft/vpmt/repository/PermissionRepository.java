package com.v2soft.vpmt.repository;

import com.v2soft.vpmt.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {}
