package com.example.userservice.controller;

import com.example.userservice.dto.UserRequest;
import com.example.userservice.dto.UserResponse;
import com.example.userservice.model.User;
import com.example.userservice.model.UserRole;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        User user = mapToUser(userRequest);
        User savedUser = userService.createUser(user);
        return mapToUserResponse(savedUser);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(this::mapToUserResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(mapToUserResponse(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        User user = mapToUser(userRequest);
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(mapToUserResponse(updatedUser));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/verify")
    public ResponseEntity<Boolean> verifyUserRole(@RequestParam Long userId, @RequestParam UserRole requiredRole) {
        boolean hasRole = userService.verifyUserRole(userId, requiredRole);
        return ResponseEntity.ok(hasRole);
    }

    // Helper method to map UserRequest to User entity
    private User mapToUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .phoneNumber(userRequest.getPhoneNumber())
                .userType(userRequest.getUserType())
                .role(userRequest.getRole())
                .department(userRequest.getDepartment())
                .isActive(userRequest.getIsActive() != null ? userRequest.getIsActive() : true) // Default to true if null
                .build();
    }

    // Helper method to map User entity to UserResponse DTO
    private UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .userType(user.getUserType())
                .role(user.getRole())
                .department(user.getDepartment()) // Include department in the response
                .isActive(user.getIsActive()) // Ensure this field is correctly mapped
                .build();
    }
}
