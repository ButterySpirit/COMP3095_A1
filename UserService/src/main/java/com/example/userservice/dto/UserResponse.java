package com.example.userservice.dto;

import com.example.userservice.model.UserRole;
import com.example.userservice.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private UserType userType;
    private UserRole role;
    private Boolean isActive;
}
