package com.example.userservice.repository;

import com.example.userservice.model.User;
import com.example.userservice.model.UserRole;
import com.example.userservice.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Find user by email
    Optional<User> findByEmail(String email);

    // Find users by role
    List<User> findByRole(UserRole role);

    // Find users by type
    List<User> findByUserType(UserType userType);

    // Find active users
    List<User> findByIsActiveTrue();

    // Find users by department
    List<User> findByDepartment(String department);

    // Check if email exists
    boolean existsByEmail(String email);
}