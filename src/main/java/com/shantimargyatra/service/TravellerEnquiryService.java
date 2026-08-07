package com.shantimargyatra.service;

import java.util.List;

import com.shantimargyatra.entity.TravellerEnquiry;

public interface TravellerEnquiryService {

    String saveEnquiry(TravellerEnquiry enquiry);

    List<TravellerEnquiry> getAllEnquiries();

}