package com.v2soft.vpmt.controller;


import com.v2soft.vpmt.dto.AuthRequest;
import com.v2soft.vpmt.dto.AuthResponse;
import com.v2soft.vpmt.dto.RegisterRequest;
import com.v2soft.vpmt.model.Permission;
import com.v2soft.vpmt.model.Role;
import com.v2soft.vpmt.model.UserEntity;
import com.v2soft.vpmt.repository.RoleRepository;
import com.v2soft.vpmt.repository.UserRepository;
import com.v2soft.vpmt.service.JwtService;
import com.v2soft.vpmt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private UserRepository userRepo;
    @Autowired private RoleRepository roleRepo;
    @Autowired private PasswordEncoder encoder;
    @Autowired private JwtService jwtService;
    @Autowired private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        if (userRepo.findByUsername(request.getUsername()).isPresent())
            return ResponseEntity.badRequest().body("Username already exists");

        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        Set<Role> roles = request.getRoles().stream()
                .map(roleName -> roleRepo.findByName(roleName).orElseThrow())
                .collect(Collectors.toSet());
        user.setRoles(roles);
        userRepo.save(user);
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        UserEntity user = userRepo.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        List<String> permissions = user.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(Permission::getName)
                .distinct()
                .collect(Collectors.toList());
        return ResponseEntity.ok(new AuthResponse(token, permissions));
    }
}

