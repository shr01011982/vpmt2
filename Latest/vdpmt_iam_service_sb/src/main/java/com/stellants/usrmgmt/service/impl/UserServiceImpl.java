package com.stellants.usrmgmt.service.impl;

import com.stellants.usrmgmt.dto.UserDTO;
import com.stellants.usrmgmt.entity.Role;
import com.stellants.usrmgmt.entity.User;
import com.stellants.usrmgmt.exception.ResourceNotFoundException;
import com.stellants.usrmgmt.exception.UserAlreadyExistsException;
import com.stellants.usrmgmt.repository.RoleRepository;
import com.stellants.usrmgmt.repository.UserRepository;
import com.stellants.usrmgmt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(PasswordEncoder passwordEncoder, RoleRepository roleRepository, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO dto) {
        Optional<User> existing = userRepository.findByEmail(dto.getEmail());
//        if (existing.isPresent()) {
//            throw new RuntimeException("Email already exists: " + dto.getEmail());
//        }
        if (existing.isPresent()) {
            throw new UserAlreadyExistsException("User with email already exists: " + dto.getEmail());
        }


        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        User saved = userRepository.save(user);

        UserDTO response = toDTO(saved);
        response.setId(saved.getId());
        response.setUsername(saved.getUsername());
        response.setEmail(saved.getEmail());
//        response.setRoleId(null);
  //      response.setRoleName(null);
        return response;
    }

//    @Override
//    public UserDTO assignRole(Long userId, Long roleId) {
//        User user = userRepository.findById(userId).orElseThrow();
//        Role role = roleRepository.findById(roleId).orElseThrow();
//        user.setRole(role);
//        User updated = userRepository.save(user);
//        return toDTO(updated);
//    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO update(Long id, UserDTO dto) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        if (dto.getPassword() != null) user.setPassword(dto.getPassword());
        User updated = userRepository.save(user);
        return toDTO(updated);
    }
    @Override
    public UserDTO assignRole(Long userId, Long roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with ID: " + roleId));

        user.setRole(role);  // ✅ Only update the role
        User updatedUser = userRepository.save(user);

        UserDTO response = new UserDTO();
        response.setId(updatedUser.getId());
        response.setUsername(updatedUser.getUsername());
        response.setEmail(updatedUser.getEmail());
        response.setRoleId(role.getId());
        response.setRoleName(role.getName());

        return response;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        if (user.getRole() != null) {
            dto.setRoleId(user.getRole().getId());
            dto.setRoleName(user.getRole().getName());
        }
        return dto;
    }
}
