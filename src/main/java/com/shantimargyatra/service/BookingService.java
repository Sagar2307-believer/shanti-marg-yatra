package com.shantimargyatra.service;

import java.util.List;

import com.shantimargyatra.entity.Booking;

public interface BookingService {
public String saveBooking(Booking booking);
public List<Booking> getAllBookings();
}
