package com.shantimargyatra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shantimargyatra.entity.TravellerEnquiry;

@Repository
public interface TravellerEnquiryRepository extends JpaRepository<TravellerEnquiry, Long> {

}