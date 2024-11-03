package com.example.eventservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    @Id
    private String id;

    @Indexed
    private String eventName;

    @Indexed
    private Long organizerId;

    private String organizerName;

    private String organizerEmail;

    @Indexed
    private String bookingId;  // Reference to the Booking document

    private Long roomId;       // Reference to the Room

    private String roomName;

    @Indexed
    private EventType eventType;

    private Integer expectedAttendees;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String description;

    private List<String> requirements;  // Special requirements for the event

    private EventStatus status;

    private String department;  // Department organizing the event

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}