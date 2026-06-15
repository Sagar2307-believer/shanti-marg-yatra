package com.shantimargyatra.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shantimargyatra.entity.Booking;
import com.shantimargyatra.repository.BookingRepository;
import com.shantimargyatra.service.BookingService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
 private final BookingRepository bookingRepository;
	@Override
	
	public String saveBooking(Booking booking) {
	 bookingRepository.save(booking);
		return "Booking Successful!! Will short connectly";
	}
	@Override
	public List<Booking> getAllBookings() {
		 return bookingRepository.findAll(
			        Sort.by(Sort.Direction.DESC, "registrationDate")
			    );
	}

}
