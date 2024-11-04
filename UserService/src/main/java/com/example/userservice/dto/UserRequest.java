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
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private UserType userType;
    private UserRole role;
    private String department;
    private Boolean isActive; // Add this field

    // Add getter and setter for isActive
    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    // Getters and Setters
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

