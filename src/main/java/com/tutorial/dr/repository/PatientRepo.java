package com.tutorial.dr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.tutorial.dr.model.Patient;

import jakarta.transaction.Transactional;

public interface PatientRepo extends JpaRepository<Patient, Long> {

	Patient findFirstByEmail(String email);

	
	@Modifying
	@Transactional
	@Query(value = "update tbl_patient set symptom=:symptom where id=:patId",nativeQuery = true)

	void updateById(Long patId, String symptom);
	
	
	

}
