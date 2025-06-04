package com.v2soft.vpmt.controller;

import com.v2soft.vpmt.Entity.Project;
import com.v2soft.vpmt.Entity.User;
import com.v2soft.vpmt.JwtUtil;
import com.v2soft.vpmt.Repository.ProjectRepository;
import com.v2soft.vpmt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/user")
    public ResponseEntity<?> getProjects(@RequestHeader("Authorization") String header) {
        String token = header.substring(7);
        String username = jwtUtil.extractUsername(token);
        User user = userRepo.findByUsername(username).orElse(null);
        if (user != null) {
            List<Project> projects = projectRepo.findByUserId(user.getId());
            return ResponseEntity.ok(projects);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}

