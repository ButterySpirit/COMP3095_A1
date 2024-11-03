package com.example.userservice.service;

import com.example.userservice.model.User;
import com.example.userservice.model.UserRole;
import java.util.List;

public interface UserService {
    // Create operation
    User createUser(User user);

    // Read operations
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByEmail(String email);

    // Update operation
    User updateUser(Long id, User user);

    // Delete operation
    void deleteUser(Long id);

    // Utility methods
    boolean existsByEmail(String email);
    boolean verifyUserRole(Long userId, UserRole requiredRole);
}