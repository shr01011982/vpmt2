package com.stellants.vdpmt.service.impl;

import com.stellants.vdpmt.dto.RoleDTO;
import com.stellants.vdpmt.entity.Role;
import com.stellants.vdpmt.repository.RoleRepository;
import com.stellants.vdpmt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createRole(RoleDTO dto) {
        Role role = new Role(null, dto.getName(), dto.getDescription());
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
