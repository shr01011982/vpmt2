package com.stellants.vdpmt.repository;

import com.stellants.vdpmt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    boolean existsByName(String name);
}
