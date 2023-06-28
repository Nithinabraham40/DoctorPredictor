package com.tutorial.dr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.dr.dao.PatientSignIn;
import com.tutorial.dr.dao.Symptomdto;
import com.tutorial.dr.model.Patient;
import com.tutorial.dr.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	
	@Autowired
	private PatientService patientService;
	
	
	
	@PostMapping("/signup")
	
	public ResponseEntity<String>signUp(@RequestBody Patient patient){
		
		return patientService.signUp(patient);
	}
	@PostMapping("/signin")
	
	public ResponseEntity<String>signIn(@RequestBody PatientSignIn input){
		
		return patientService.signIn(input);
	}
	@PutMapping("addsymptom/{email}/{token}")
	public ResponseEntity<String>addSymptom(@PathVariable("email") String email,@PathVariable("token") String token,@RequestBody Symptomdto symptom){
		
		return patientService.addSymptom(email,token,symptom);
		
	}
	
	@GetMapping("getDoctor/{email}/{token}")
	
	public ResponseEntity<String>getDoctor(@PathVariable("email") String email,@PathVariable("token") String token){
		
		return patientService.getDoctor(email,token);
		
	}
       
	
	
	
}
