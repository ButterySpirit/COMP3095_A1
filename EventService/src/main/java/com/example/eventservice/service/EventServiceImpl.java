package com.example.eventservice.service;

import com.example.eventservice.model.Event;
import com.example.eventservice.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> getEventById(String id) {
        return eventRepository.findById(id);
    }

    @Override
    public Event updateEvent(String id, Event eventDetails) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setEventName(eventDetails.getEventName());
        event.setOrganizerId(eventDetails.getOrganizerId());
        event.setOrganizerName(eventDetails.getOrganizerName());
        event.setOrganizerEmail(eventDetails.getOrganizerEmail());
        event.setBookingId(eventDetails.getBookingId());
        event.setRoomId(eventDetails.getRoomId());
        event.setRoomName(eventDetails.getRoomName());
        event.setEventType(eventDetails.getEventType());
        event.setExpectedAttendees(eventDetails.getExpectedAttendees());
        event.setStartTime(eventDetails.getStartTime());
        event.setEndTime(eventDetails.getEndTime());
        event.setDescription(eventDetails.getDescription());
        event.setRequirements(eventDetails.getRequirements());
        event.setStatus(eventDetails.getStatus());
        event.setDepartment(eventDetails.getDepartment());

        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }
}
