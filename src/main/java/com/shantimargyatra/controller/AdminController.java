package com.shantimargyatra.controller;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

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

        var bookings = bookingService.getAllBookings();
        var users = userService.getAllUsers();
        var packages = packageService.getAllPackages();

        LocalDate today = LocalDate.now();

        long todayBookings = bookings.stream()
                .filter(b -> today.equals(b.getRegistrationDate()))
                .count();

        long todayUsers = bookings.stream()
                .filter(b -> today.equals(b.getRegistrationDate()))
                .map(b -> b.getUserId())
                .distinct()
                .count();
        Map<Long, String> userNames = userService.getAllUsers()
                .stream()
                .collect(Collectors.toMap(
                        u -> u.getId(),
                        u -> u.getName()
                ));

        Map<Long, String> packageNames = packageService.getAllPackages()
                .stream()
                .collect(Collectors.toMap(
                        p -> p.getId(),
                        p -> p.getName()
                ));
        Map<Long, String> userMobiles = userService.getAllUsers()
                .stream()
                .collect(Collectors.toMap(
                        u -> u.getId(),
                        u -> u.getMobile()
                ));


        model.addAttribute("userNames", userNames);
        model.addAttribute("packageNames", packageNames);
        model.addAttribute("userMobiles", userMobiles);

        model.addAttribute("bookings", bookings);
        model.addAttribute("users", users);
        model.addAttribute("packages", packages);

        model.addAttribute("todayBookings", todayBookings);
        model.addAttribute("todayUsers", todayUsers);

        return "admin-dashboard";
    }
}