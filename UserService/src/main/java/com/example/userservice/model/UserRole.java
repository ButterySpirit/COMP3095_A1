package com.example.userservice.model;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN,   // Can manage all aspects of the system
    USER     // Regular user with basic permissions
}
