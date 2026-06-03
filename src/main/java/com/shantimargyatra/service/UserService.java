package com.shantimargyatra.service;

import java.util.List;

import com.shantimargyatra.entity.User;

public interface UserService {
	 public User saveUser(User user);
	 public List<User> getAllUsers();
	 public User getUserById(Long userId);
}
