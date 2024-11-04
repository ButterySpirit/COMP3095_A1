package com.example.bookingservice.repository;

import com.example.bookingservice.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByRoomIdAndStartTimeBeforeAndEndTimeAfter(Long roomId, LocalDateTime endTime, LocalDateTime startTime);
}
