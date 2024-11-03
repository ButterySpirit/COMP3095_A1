package com.example.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@CompoundIndex(
        name = "room_booking_time_idx",
        def = "{'roomId': 1, 'startTime': 1, 'endTime': 1}",
        unique = true
)
public class Booking {
    @Id
    private String id;

    @Indexed
    private Long roomId;

    @Indexed
    private Long userId;

    @Indexed
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String purpose;

    private BookingStatus status;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private Integer expectedAttendees;

    private String contactPhone;

    private String contactEmail;

    private String bookingNotes;
}