package com.shantimargyatra.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shantimargyatra.service.BookingService;
import com.shantimargyatra.service.PackageService;
import com.shantimargyatra.service.UserService;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final BookingService bookingService;
    private final UserService userService;
    private final PackageService packageService;

    @GetMapping("/admin")
    public String adminDashboard(Model model) {

        model.addAttribute("bookings", bookingService.getAllBookings());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("packages", packageService.getAllPackages());
        return "admin-dashboard";
    }
}