package com.example.bookingservice.service;

import com.example.bookingservice.model.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking getBookingById(String id);
    List<Booking> getAllBookings();
    Booking updateBooking(String id, Booking bookingDetails);
    void deleteBooking(String id);
}
