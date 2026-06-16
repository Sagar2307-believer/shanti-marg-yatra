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
import com.shantimargyatra.service.TelegramService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
 private final BookingRepository bookingRepository;
 //private final EmailService emailService;
 private final UserRepository userRepository;
 private final PackageRepository packageRepository;
 private final TelegramService telegramService;
	@Override
	public String saveBooking(Booking booking) {

	    bookingRepository.save(booking);
try {
	    User user = userRepository
	            .findById(booking.getUserId())
	            .orElseThrow();

	    com.shantimargyatra.entity.Package tourPackage = packageRepository
	            .findById(booking.getPackageId())
	            .orElseThrow();
	    String msg =
	            "🔔 New Booking Received\n\n"
	            + "👤 Customer: " + user.getName() + "\n"
	            + "📞 Mobile: " + user.getMobile() + "\n\n"
	            + "🛕 Package: " + tourPackage.getName() + "\n"
	            + "📅 Travel Date: " + booking.getTravelDate() + "\n"
	            + "⏰ Arrival Time: " + booking.getArrivalTime() + "\n"
	            + "👥 Persons: " + booking.getPersons();

	    telegramService.sendMessage(msg);
}catch (Exception e) {

    System.out.println("Telegram notification failed: "
            + e.getMessage());
}


//	    try {
//	        emailService.sendBookingNotification(
//	                booking,
//	                user,
//	                tourPackage);
//	    } catch (Exception e) {
//	        System.out.println("Email notification failed: " + e.getMessage());
//	    }

		return "Booking Successful!! Will short connectly";
	}
	@Override
	public List<Booking> getAllBookings() {
		 return bookingRepository.findAll(
			        Sort.by(Sort.Direction.DESC, "registrationDate")
			    );
	}

}
