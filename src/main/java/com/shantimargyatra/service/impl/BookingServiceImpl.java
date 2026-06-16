package com.shantimargyatra.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shantimargyatra.entity.Booking;
import com.shantimargyatra.entity.User;
import com.shantimargyatra.repository.BookingRepository;
import com.shantimargyatra.repository.PackageRepository;
import com.shantimargyatra.repository.UserRepository;
import com.shantimargyatra.service.BookingService;
import com.shantimargyatra.service.EmailService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
 private final BookingRepository bookingRepository;
 private final EmailService emailService;
 private final UserRepository userRepository;
 private final PackageRepository packageRepository;
	@Override
	public String saveBooking(Booking booking) {

	    bookingRepository.save(booking);

	    User user = userRepository
	            .findById(booking.getUserId())
	            .orElseThrow();

	    com.shantimargyatra.entity.Package tourPackage = packageRepository
	            .findById(booking.getPackageId())
	            .orElseThrow();

	    try {
	        emailService.sendBookingNotification(
	                booking,
	                user,
	                tourPackage);
	    } catch (Exception e) {
	        System.out.println("Email notification failed: " + e.getMessage());
	    }

		return "Booking Successful!! Will short connectly";
	}
	@Override
	public List<Booking> getAllBookings() {
		 return bookingRepository.findAll(
			        Sort.by(Sort.Direction.DESC, "registrationDate")
			    );
	}

}
