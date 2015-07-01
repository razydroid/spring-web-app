package com.ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ua.entity.user;

public interface UserRepository extends JpaRepository<user, Integer>{
	
	
	@Query("SELECT u FROM user u WHERE u.name = :userName AND u.password = :password")
    public user find(@Param("userName") String userName,@Param("password") String password);

}
