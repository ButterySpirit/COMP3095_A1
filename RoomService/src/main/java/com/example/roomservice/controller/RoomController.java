package com.example.roomservice.controller;

import com.example.roomservice.dto.RoomRequest;
import com.example.roomservice.model.Room;
import com.example.roomservice.model.RoomStatus;
import com.example.roomservice.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody RoomRequest roomRequest) {
        Room room = Room.builder()
                .roomName(roomRequest.getRoomName())
                .capacity(roomRequest.getCapacity())
                .building(roomRequest.getBuilding())
                .floor(roomRequest.getFloor())
                .features(roomRequest.getFeatures())
                .roomType(roomRequest.getRoomType())
                .status(roomRequest.getStatus())
                .isActive(roomRequest.getIsActive())
                .build();

        Room savedRoom = roomService.createRoom(room);
        return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        Room room = roomService.getRoomById(id);
        if (room != null) {
            return ResponseEntity.ok(room);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody RoomRequest roomRequest) {
        Room room = Room.builder()
                .roomName(roomRequest.getRoomName())
                .capacity(roomRequest.getCapacity())
                .building(roomRequest.getBuilding())
                .floor(roomRequest.getFloor())
                .features(roomRequest.getFeatures())
                .roomType(roomRequest.getRoomType())
                .status(roomRequest.getStatus())
                .isActive(roomRequest.getIsActive())
                .build();

        Room updatedRoom = roomService.updateRoom(id, room);
        return ResponseEntity.ok(updatedRoom);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status")
    public ResponseEntity<List<Room>> getRoomsByStatus(@RequestParam RoomStatus status) {
        List<Room> rooms = roomService.getRoomsByStatus(status);
        return ResponseEntity.ok(rooms);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Room> updateRoomStatus(@PathVariable Long id, @RequestBody RoomStatus status) {
        Room updatedRoom = roomService.updateRoomStatus(id, status);
        return ResponseEntity.ok(updatedRoom);
    }

}
