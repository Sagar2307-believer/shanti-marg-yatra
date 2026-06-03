package com.shantimargyatra.service;

import java.util.List;

public interface PackageService {
List<com.shantimargyatra.entity.Package> getAllPackages();

com.shantimargyatra.entity.Package getPackageById(Long packageId);
}
