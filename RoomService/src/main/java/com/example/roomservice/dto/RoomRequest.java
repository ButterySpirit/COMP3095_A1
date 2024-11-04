package com.example.roomservice.dto;

import com.example.roomservice.model.RoomFeature;
import com.example.roomservice.model.RoomStatus;
import com.example.roomservice.model.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data // This Lombok annotation automatically generates getters, setters, equals, hashCode, and toString methods.
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequest {
    private String roomName;
    private Integer capacity;
    private String building;
    private String floor;
    private Set<RoomFeature> features;
    private RoomType roomType;
    private RoomStatus status;
    private Boolean isActive;
}
