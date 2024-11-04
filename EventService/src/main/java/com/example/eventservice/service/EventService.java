package com.example.eventservice.service;

import com.example.eventservice.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Event createEvent(Event event);
    List<Event> getAllEvents();
    Optional<Event> getEventById(String id);
    Event updateEvent(String id, Event event);
    void deleteEvent(String id);
}
