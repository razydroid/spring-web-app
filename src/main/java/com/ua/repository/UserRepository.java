package com.ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ua.entity.user;

public interface UserRepository extends JpaRepository<user, Integer>{

}
