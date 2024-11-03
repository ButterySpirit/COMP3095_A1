package com.example.roomservice.model;

import lombok.Getter;

@Getter
public enum RoomStatus {
    AVAILABLE,
    OCCUPIED,
    MAINTENANCE,
    OUT_OF_SERVICE
}
