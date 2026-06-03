package com.shantimargyatra.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shantimargyatra.entity.Package;
import com.shantimargyatra.repository.PackageRepository;
import com.shantimargyatra.service.PackageService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class PackageServiceImpl implements PackageService {
private final PackageRepository packageRepository;
	@Override
	public List<Package> getAllPackages() {
		
		return packageRepository.findAll();
	}
	@Override
	public Package getPackageById(Long packageId) {
		// TODO Auto-generated method stub
		return packageRepository.getById(packageId);
	}

}
