package com.stellants.usrmgmt.controller;

import com.stellants.usrmgmt.dto.UserDTO;
import com.stellants.usrmgmt.exception.UserAlreadyExistsException;
import com.stellants.usrmgmt.response.ApiResponse;
import com.stellants.usrmgmt.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<UserDTO>> createUser(@Valid @RequestBody UserDTO userDTO) {
        try {
            UserDTO createdUser = userService.createUser(userDTO);
            return ResponseEntity.ok(new ApiResponse<>(
                    "success",
                    200,
                    "User added successfully",
                    createdUser
            ));
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse<>(
                    "error",
                    409,
                    e.getMessage(),
                    null
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(
                    "error",
                    500,
                    "An unexpected error occurred",
                    null
            ));
        }
//        UserDTO saved = userService.createUser(userDTO);
//        return ResponseEntity.ok(new ApiResponse<>(
//                "success", 200, "User added suceessfully",
//                saved, "aasadasdadasdads")); // Dummy token
    }
//    @PutMapping("/{userId}/role/{roleId}")
//    public ResponseEntity<ApiResponse> assignRoleToUser(
//            @PathVariable Long userId,
//            @PathVariable Long roleId) {
//
//        UserResponseDto dto = userService.updateUserRole(userId, roleId);
//        return ResponseEntity.ok(new ApiResponse("Success", 200, "Role assigned successfully", dto));
//    }

//    @PostMapping("/{id}/role")
//    public ResponseEntity<ApiResponse<UserDTO>> assignRole(
//            @PathVariable Long id,
//            @RequestParam Long roleId) {
//        UserDTO dto = userService.assignRole(id, roleId);
//        return ResponseEntity.ok(new ApiResponse<>(
//                "success", 200, "Role assigned suceessfully",
//                userService.assignRole(id, roleId)));
//    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDTO>>> getAll() {
        return ResponseEntity.ok(new ApiResponse<>(
                "success", 200, "User Listing",
                userService.getAll()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> update(
            @PathVariable Long id, @RequestBody UserDTO dto) {
        return ResponseEntity.ok(new ApiResponse<>(
                "success", 200, "User updated suceessfully",
                userService.update(id, dto)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/role")
    public ResponseEntity<UserDTO> updateUserRole(@PathVariable Long id, @RequestParam Long roleId) {
        UserDTO updated = userService.assignRole(id, roleId);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<List<Object>>> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(
                "success", 200, "User deleted suceessfully",
                List.of()));
    }
}
