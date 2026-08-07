package com.shantimargyatra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.shantimargyatra.entity.TravellerEnquiry;
import com.shantimargyatra.service.TravellerEnquiryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TravellerEnquiryController {

    private final TravellerEnquiryService travellerEnquiryService;

    @GetMapping("/plan-your-journey")
    public String planYourJourney(Model model) {

        model.addAttribute("enquiry", new TravellerEnquiry());

        return "plan-your-journey";
    }

    @PostMapping("/plan-your-journey")
    public String saveEnquiry(
            @ModelAttribute("enquiry") TravellerEnquiry enquiry,
            RedirectAttributes redirectAttributes) {

        String message = travellerEnquiryService.saveEnquiry(enquiry);

        redirectAttributes.addFlashAttribute("success", message);

        return "redirect:/thank-you";
    }

}