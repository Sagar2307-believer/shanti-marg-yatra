package com.shantimargyatra.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shantimargyatra.entity.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	List<Booking> findByRegistrationDate(LocalDate registrationDate);
}
