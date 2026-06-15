package com.shantimargyatra.service.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.shantimargyatra.entity.Booking;
import com.shantimargyatra.entity.Package;
import com.shantimargyatra.entity.User;
import com.shantimargyatra.service.EmailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendBookingNotification(
            Booking booking,
            User user,
            Package tourPackage) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("sagarjaiswal23072002@gmail.com");

        message.setSubject("🔔 New Booking Received");

        message.setText(
                "Customer Name : " + user.getName() + "\n" +
                "Mobile Number : " + user.getMobile() + "\n\n" +
                "Package : " + tourPackage.getName() + "\n" +
                "Travel Date : " + booking.getTravelDate() + "\n" +
                "Arrival Time : " + booking.getArrivalTime() + "\n" +
                "Persons : " + booking.getPersons()
        );

        mailSender.send(message);
    }
}