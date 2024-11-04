package com.example.bookingservice.service;

import com.example.bookingservice.model.Booking;
import com.example.bookingservice.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(String id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(String id, Booking bookingDetails) {
        Booking booking = getBookingById(id);

        booking.setRoomId(bookingDetails.getRoomId());
        booking.setUserId(bookingDetails.getUserId());
        booking.setStartTime(bookingDetails.getStartTime());
        booking.setEndTime(bookingDetails.getEndTime());
        booking.setPurpose(bookingDetails.getPurpose());
        booking.setStatus(bookingDetails.getStatus());
        booking.setExpectedAttendees(bookingDetails.getExpectedAttendees());
        booking.setContactPhone(bookingDetails.getContactPhone());
        booking.setContactEmail(bookingDetails.getContactEmail());
        booking.setBookingNotes(bookingDetails.getBookingNotes());

        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(String id) {
        bookingRepository.deleteById(id);
    }
}
