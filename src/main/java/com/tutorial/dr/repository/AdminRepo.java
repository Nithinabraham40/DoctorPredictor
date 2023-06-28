package com.tutorial.dr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.dr.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long>{

	Admin findFirstByEmail(String email);

}
