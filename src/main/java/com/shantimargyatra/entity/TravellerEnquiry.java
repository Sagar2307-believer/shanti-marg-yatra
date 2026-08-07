package com.shantimargyatra.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "traveller_enquiry")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravellerEnquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    private String mobile;

    private String email;

    private String city;

    private Integer adults;

    private Integer children;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "return_time")
    private LocalTime returnTime;

    @Column(name = "arrival_by")
    private String arrivalBy;

    @Column(name = "pickup_required")
    private Boolean pickupRequired;

    @Column(name = "pickup_location")
    private String pickupLocation;

    @Column(name = "hotel_required")
    private Boolean hotelRequired;

    @Column(name = "hotel_category")
    private String hotelCategory;

    @Column(name = "special_request", columnDefinition = "TEXT")
    private String specialRequest;

    private String source;

    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}