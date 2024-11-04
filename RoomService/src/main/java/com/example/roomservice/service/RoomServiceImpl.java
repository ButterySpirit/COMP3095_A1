package com.example.roomservice.service;

import com.example.roomservice.model.Room;
import com.example.roomservice.model.RoomStatus;
import com.example.roomservice.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> getRoomsByStatus(RoomStatus status) {  // Implement this method
        return roomRepository.findByStatus(status);
    }

    @Override
    public Room updateRoom(Long id, Room room) {
        room.setId(id);
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoomStatus(Long id, RoomStatus status) {
        Room room = getRoomById(id);
        room.setStatus(status);
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        if (!roomRepository.existsById(id)) {
            throw new RoomNotFoundException("Room with ID " + id + " not found");
        }
        roomRepository.deleteById(id);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class RoomNotFoundException extends RuntimeException {
        public RoomNotFoundException(String message) {
            super(message);
        }
    }

}
