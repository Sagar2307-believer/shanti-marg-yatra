package com.shantimargyatra.service;

import com.shantimargyatra.entity.Booking;
import com.shantimargyatra.entity.Package;
import com.shantimargyatra.entity.User;

public interface EmailService {

    void sendBookingNotification(
            Booking booking,
            User user,
            Package tourPackage);
}