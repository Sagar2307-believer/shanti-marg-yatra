package com.shantimargyatra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shantimargyatra.entity.Booking;
import com.shantimargyatra.entity.User;
import com.shantimargyatra.repository.BookingRepository;
import com.shantimargyatra.repository.UserRepository;
import com.shantimargyatra.service.BookingService;
import com.shantimargyatra.service.PackageService;
import com.shantimargyatra.service.UserService;
import com.shantimargyatra.service.impl.PackageServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PackageController {
private final PackageService packageService;
private final UserService userService;
private final BookingService bookingService;
	@GetMapping("/")
public String home() {
    return "home-page";
}
@GetMapping("/packages")
public String viewPackages(Model model)
{
	model.addAttribute("packages", packageService.getAllPackages());
	return "packages";

}
@GetMapping("/register/{id}")
public String showRegister(@PathVariable Long id, Model model) {
    model.addAttribute("user", new User());
    model.addAttribute("packageId", id);
    return "register";
}
@PostMapping("/register")
public String registerUser(@ModelAttribute User user,
                           @RequestParam Long packageId) {

    User savedUser = userService.saveUser(user);

    return "redirect:/booking/" + savedUser.getId() + "/" + packageId;
}
@GetMapping("/booking/{userId}/{packageId}")
public String bookingPage(@PathVariable Long userId,
                          @PathVariable Long packageId,
                          Model model) {
System.err.println(userId);
System.err.println(packageId);
//    model.addAttribute("booking", new Booking());
//    model.addAttribute("userId", userId);
//    model.addAttribute("packageId", packageId);
Booking booking = new Booking();
booking.setUserId(userId);
booking.setPackageId(packageId);

model.addAttribute("booking", booking);
    return "booking";
}
//@PostMapping("/booking")
//public String saveBooking(@ModelAttribute Booking booking) {
// bookingService.saveBooking(booking);
// return "success";
//}
@PostMapping("/booking")
public String saveBooking(@ModelAttribute Booking booking, Model model){
    bookingService.saveBooking(booking);

    User user = userService.getUserById(booking.getUserId());
    com.shantimargyatra.entity.Package pkg = packageService.getPackageById(booking.getPackageId());

    model.addAttribute("userName", user.getName());
    model.addAttribute("packageName", pkg.getName());
    model.addAttribute("travelDate", booking.getTravelDate());
    model.addAttribute("arrivalTime", booking.getArrivalTime());
    model.addAttribute("persons", booking.getPersons());
    model.addAttribute("price", pkg.getPrice() * booking.getPersons());

    return "success";
}
@GetMapping("/homepage")
public String homePage() {
	
	return "home-page";
}
@GetMapping("/about")
public String aboutSection() {
	return "about-section";
}
@GetMapping("/services")
public String servicesSection() {
	return "services-section";
	
}
@GetMapping("/package-details/{id}")
public String packageDetails(@PathVariable Long id,
                             Model model){

	com.shantimargyatra.entity.Package pkg =
            packageService.getPackageById(id);

    model.addAttribute("pkg", pkg);

    return "package-details";
}
}
