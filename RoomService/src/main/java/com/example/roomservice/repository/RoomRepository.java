package com.example.roomservice.repository;

import com.example.roomservice.model.Room;
import com.example.roomservice.model.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {


    List<Room> findByStatus(RoomStatus status);
}
