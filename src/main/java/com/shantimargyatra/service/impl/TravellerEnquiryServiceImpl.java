package com.shantimargyatra.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shantimargyatra.entity.TravellerEnquiry;
import com.shantimargyatra.repository.TravellerEnquiryRepository;
import com.shantimargyatra.service.TelegramService;
import com.shantimargyatra.service.TravellerEnquiryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravellerEnquiryServiceImpl implements TravellerEnquiryService {

    private final TravellerEnquiryRepository travellerEnquiryRepository;
    private final TelegramService telegramService;

    @Override
    public String saveEnquiry(TravellerEnquiry enquiry) {

        enquiry.setCreatedAt(LocalDateTime.now());
        enquiry.setStatus("NEW");

        travellerEnquiryRepository.save(enquiry);

        try {

            String msg =
                    "🔔 New Traveller Enquiry\n\n"
                    + "👤 Name : " + enquiry.getFullName() + "\n"
                    + "📱 Mobile : " + enquiry.getMobile() + "\n";

            if (enquiry.getEmail() != null && !enquiry.getEmail().isBlank()) {
                msg += "📧 Email : " + enquiry.getEmail() + "\n";
            }

            if (enquiry.getCity() != null && !enquiry.getCity().isBlank()) {
                msg += "🏙️ City : " + enquiry.getCity() + "\n";
            }

            msg += "\n👥 Adults : " + enquiry.getAdults()
                    + "\n👶 Children : " + enquiry.getChildren()
                    + "\n\n📅 Arrival : " + enquiry.getArrivalDate()
                    + "\n🕒 Arrival Time : " + enquiry.getArrivalTime()
                    + "\n📅 Return : " + enquiry.getReturnDate()
                    + "\n🕒 Return Time : " + enquiry.getReturnTime()
                    + "\n\n🚉 Arrival By : " + enquiry.getArrivalBy()
                    + "\n🏨 Hotel Required : " + (Boolean.TRUE.equals(enquiry.getHotelRequired()) ? "Yes" : "No");

            if (Boolean.TRUE.equals(enquiry.getHotelRequired())) {
                msg += "\n🏨 Hotel Category : " + enquiry.getHotelCategory();
            }

            if (Boolean.TRUE.equals(enquiry.getPickupRequired())) {
                msg += "\n🚖 Pickup Location : " + enquiry.getPickupLocation();
            }

            if (enquiry.getSpecialRequest() != null && !enquiry.getSpecialRequest().isBlank()) {
                msg += "\n\n📝 Special Request :\n" + enquiry.getSpecialRequest();
            }

            if (enquiry.getSource() != null && !enquiry.getSource().isBlank()) {
                msg += "\n\n📢 Source : " + enquiry.getSource();
            }

            telegramService.sendMessage(msg);

        } catch (Exception e) {
            System.out.println("Telegram notification failed : " + e.getMessage());
        }

        return "Enquiry Submitted Successfully!";
    }

    @Override
    public List<TravellerEnquiry> getAllEnquiries() {

        return travellerEnquiryRepository.findAll(
                Sort.by(Sort.Direction.DESC, "createdAt")
        );
    }

}