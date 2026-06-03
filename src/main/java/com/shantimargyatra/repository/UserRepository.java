package com.shantimargyatra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shantimargyatra.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
