package com.shantimargyatra.config;

import org.springframework.stereotype.Component;

import com.shantimargyatra.entity.Package;
import com.shantimargyatra.repository.PackageRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final PackageRepository packageRepository;

    @PostConstruct
    public void loadData() {

        // Only insert if table is empty
        if (packageRepository.count() == 0) {

            packageRepository.save(Package.builder()
                    .days(1)
                    .description("Visit Mahakaleshwar Temple and nearby Temples")
                    .imageurl("/images/package1.jpg")
                    .name("Ujjain One-Day Spiritual Tour")
                    .price(999)
                    .build());

            packageRepository.save(Package.builder()
                    .days(1)
                    .description("Divine Mahakal Yatra with Comfortable Accommodation")
                    .imageurl("/images/package2.jpg")
                    .name("Ujjain Darshan Package with Hotel Stay")
                    .price(1499)
                    .build());

            packageRepository.save(Package.builder()
                    .days(2)
                    .description("Experience the Divine Blessings of Mahakal Along with the Rich Heritage of Ujjain")
                    .imageurl("/images/package3.jpg")
                    .name("Ujjain Spiritual & Heritage Tour Package (2 Days / 1 Night)")
                    .price(2499)
                    .build());

            packageRepository.save(Package.builder()
                    .days(2)
                    .description("Experience the divine blessings of Mahakaleshwar Jyotirlinga and Omkareshwar Jyotirlinga in one memorable spiritual journey.")
                    .imageurl("/images/package4.jpg")
                    .name("Ujjain & Omkareshwar Jyotirlinga Darshan, 2 Days / 1 Night Spiritual Tour Package")
                    .price(3999)
                    .build());
        }
    }
}