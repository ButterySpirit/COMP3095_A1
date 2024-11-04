package com.example.eventservice.controller;

import com.example.eventservice.dto.EventRequest;
import com.example.eventservice.model.Event;
import com.example.eventservice.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody EventRequest eventRequest) {
        Event event = Event.builder()
                .eventName(eventRequest.getEventName())
                .organizerId(eventRequest.getOrganizerId())
                .organizerName(eventRequest.getOrganizerName())
                .organizerEmail(eventRequest.getOrganizerEmail())
                .bookingId(eventRequest.getBookingId())
                .roomId(eventRequest.getRoomId())
                .roomName(eventRequest.getRoomName())
                .eventType(eventRequest.getEventType())
                .expectedAttendees(eventRequest.getExpectedAttendees())
                .startTime(eventRequest.getStartTime())
                .endTime(eventRequest.getEndTime())
                .description(eventRequest.getDescription())
                .requirements(eventRequest.getRequirements())
                .status(eventRequest.getStatus())
                .department(eventRequest.getDepartment())
                .build();

        Event createdEvent = eventService.createEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable String id) {
        return eventService.getEventById(id)
                .map(event -> new ResponseEntity<>(event, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable String id, @RequestBody EventRequest eventRequest) {
        Event event = Event.builder()
                .eventName(eventRequest.getEventName())
                .organizerId(eventRequest.getOrganizerId())
                .organizerName(eventRequest.getOrganizerName())
                .organizerEmail(eventRequest.getOrganizerEmail())
                .bookingId(eventRequest.getBookingId())
                .roomId(eventRequest.getRoomId())
                .roomName(eventRequest.getRoomName())
                .eventType(eventRequest.getEventType())
                .expectedAttendees(eventRequest.getExpectedAttendees())
                .startTime(eventRequest.getStartTime())
                .endTime(eventRequest.getEndTime())
                .description(eventRequest.getDescription())
                .requirements(eventRequest.getRequirements())
                .status(eventRequest.getStatus())
                .department(eventRequest.getDepartment())
                .build();

        Event updatedEvent = eventService.updateEvent(id, event);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
