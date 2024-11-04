package com.example.eventservice.dto;

import com.example.eventservice.model.EventStatus;
import com.example.eventservice.model.EventType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventRequest {
    private String eventName;
    private Long organizerId;
    private String organizerName;
    private String organizerEmail;
    private String bookingId;
    private Long roomId;
    private String roomName;
    private EventType eventType;
    private Integer expectedAttendees;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
    private List<String> requirements;
    private EventStatus status;
    private String department;
}
