package com.tutorial.dr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.dr.model.Admin;
import com.tutorial.dr.model.Doctor;
import com.tutorial.dr.repository.AdminRepo;
import com.tutorial.dr.repository.DoctorRepo;
import com.tutorial.dr.repository.PatientRepo;

@RestController
@RequestMapping("/admin")
public class AdminController {

	
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	@Autowired
	private PatientRepo patientRepo;
	
	
	
	@PostMapping("add/admin")
	
	public ResponseEntity<String>addAdmin(@RequestBody Admin admin){
		
		
		adminRepo.save(admin);
		
		return new ResponseEntity<String>("Admin added",HttpStatus.OK);
		
		
		
	}
	
	@DeleteMapping("delete/doctor/{doctorid}/{email}")
	
	public ResponseEntity<String>deleteDoctor(@PathVariable("doctorid") Long id,@PathVariable("email") String email){
		
		Admin admin=adminRepo.findFirstByEmail(email);
		if(admin==null) {
			
			return new ResponseEntity<String>("Enter correct email",HttpStatus.BAD_GATEWAY);
		}
		
	doctorRepo.deleteById(id);
	
		
	return new ResponseEntity<String>("Doctor Deleted",HttpStatus.OK);
		
	}
	
	
	
	
}
