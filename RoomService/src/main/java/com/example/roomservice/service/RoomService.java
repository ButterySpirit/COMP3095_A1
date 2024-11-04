package com.example.roomservice.service;

import com.example.roomservice.model.Room;
import com.example.roomservice.model.RoomStatus;

import java.util.List;

public interface RoomService {
    Room createRoom(Room room);
    Room getRoomById(Long id);
    List<Room> getAllRooms();
    List<Room> getRoomsByStatus(RoomStatus status);  // Add this method
    Room updateRoom(Long id, Room room);
    Room updateRoomStatus(Long id, RoomStatus status);
    void deleteRoom(Long id);
}
