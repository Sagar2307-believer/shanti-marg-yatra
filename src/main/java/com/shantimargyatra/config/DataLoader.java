package com.shantimargyatra.config;

import org.springframework.stereotype.Component;

import com.shantimargyatra.repository.PackageRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader {
private final PackageRepository packageRepository;
@PostConstruct
public void loadData() {
	if(packageRepository.count()==0) {
		
		packageRepository.save(com.shantimargyatra.entity.Package.builder()
				.name("Shanti Marg 1-Day Darshan")
				.description("Visit Mahakaleshwar Temple and nearby Temples")
				.days(1)
				.price(999)
				.imageurl("")
				.build()
				);
		
		packageRepository.save(com.shantimargyatra.entity.Package.builder()
				.name("Shanti Marg 2-Day Darshan")
				.description("Visit Mahakaleshwar Temple and nearby Temples. Also Cofortable Stay")
				.days(2)
				.price(1999)
				.imageurl("")
				.build()
				);
		packageRepository.save(com.shantimargyatra.entity.Package.builder()
				.name("Shanti Marg 2-Day Premium Darshan")
				.description("Visit Mahakaleshwar Temple with VIP Entree and Premium Hotel Stay")
				.days(2)
				.price(2999)
				.imageurl("")
				.build()
				);
	}
	
	
}
}
