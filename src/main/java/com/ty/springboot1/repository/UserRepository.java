package com.ty.springboot1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot1.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{


}
