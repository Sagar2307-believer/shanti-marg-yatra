package com.shantimargyatra.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shantimargyatra.entity.User;
import com.shantimargyatra.repository.UserRepository;
import com.shantimargyatra.service.UserService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserRepository userRepository;
	 public User saveUser(User user) {
          return userRepository.save(user);
	    }
	 @Override
	 public List<User> getAllUsers() {
		 return userRepository.findAll();
	 }
	 @Override
	 public User getUserById(Long userId) {
		// TODO Auto-generated method stub
		return userRepository.getById(userId);
	 }
}
