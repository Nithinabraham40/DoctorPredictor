package com.tutorial.dr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.dr.model.Authentication;

public interface AuthRepo extends JpaRepository<Authentication, Long>{

	Authentication findFirstByToken(String token);
	

}
