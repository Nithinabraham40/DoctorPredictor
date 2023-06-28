package com.tutorial.dr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.dr.model.Doctor;
import com.tutorial.dr.model.Speciality;

public interface DoctorRepo extends JpaRepository<Doctor, Long>{

	List<Doctor>findBySpeciality(Speciality speciality);

}
