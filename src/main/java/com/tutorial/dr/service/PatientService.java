package com.tutorial.dr.service;

import java.util.HashMap;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tutorial.dr.dao.PatientSignIn;
import com.tutorial.dr.dao.Symptomdto;
import com.tutorial.dr.model.Authentication;
import com.tutorial.dr.model.City;
import com.tutorial.dr.model.Doctor;
import com.tutorial.dr.model.Patient;
import com.tutorial.dr.model.Speciality;
import com.tutorial.dr.model.Symptom;
import com.tutorial.dr.repository.AuthRepo;
import com.tutorial.dr.repository.DoctorRepo;
import com.tutorial.dr.repository.PatientRepo;



@Service
public class PatientService {

	
	
	@Autowired
	private PatientRepo patientRepo;
	
	
	@Autowired
	private AuthRepo authRepo;
	
	@Autowired
	private DoctorRepo doctorRepo;

	public ResponseEntity<String> signUp(Patient patient) {
		
		String email=patient.getEmail();
		Patient p1=patientRepo.findFirstByEmail(email);
		if(p1!=null) {
			return new ResponseEntity<String>("alredy registed",HttpStatus.BAD_GATEWAY);
		}
		String password=patient.getPassword();
		String encrypass=encryptPassword(password);
		patient.setPassword(encrypass);
		patientRepo.save(patient);
		return new ResponseEntity<String>("signup sucess",HttpStatus.OK);
	}
	
	
	private String encryptPassword(String password) {
	      
	     String salt = BCrypt.gensalt();

	     
	     String hashedPassword = BCrypt.hashpw(password, salt);

	     return hashedPassword;
	 }

     //verify password
     
	   private boolean verifyPassword(String password, String hashedPassword) {
	    return BCrypt.checkpw(password, hashedPassword);
	}


	public ResponseEntity<String> signIn(PatientSignIn input) {
	
	String email=input.getEmail();
	Patient patient=patientRepo.findFirstByEmail(email);
	if(patient==null) {
		return new ResponseEntity<String>("Enter valid email",HttpStatus.BAD_GATEWAY);
	}
		
	String encryPass=patient.getPassword();
	
	boolean verify=verifyPassword(input.getPassword(), encryPass);
	
	if(verify==false) {
		return new ResponseEntity<String>("Invalid password",HttpStatus.BAD_GATEWAY);
	}
	
	
	Authentication authentication=new Authentication(patient);
	
	authRepo.save(authentication);
		
	return new ResponseEntity<String>("SignIn Sucess token is "+authentication.getToken(),HttpStatus.OK);
	}


	public ResponseEntity<String> addSymptom(String email, String token, Symptomdto symptom) {
		
		
		boolean check=verifyTokenAndEmail(token,email);
		if(check==false) {
			return new ResponseEntity<String>("Updation not possible",HttpStatus.BAD_GATEWAY);
			
		}
		

		Patient p1=patientRepo.findFirstByEmail(email);
		
		Long patId=p1.getId();
		
		String sym=symptom.getSymptom().toString();
		
		patientRepo.updateById(patId,sym);		
		
		return new ResponseEntity<String>("Updation is sucess",HttpStatus.OK);
	}

	
private boolean verifyTokenAndEmail(String token, String email) {
	
		
		Authentication authentication=authRepo.findFirstByToken(token);
		
		if(authentication==null) {
			return false;
		}
		
		String patientmail=authentication.getPatient().getEmail();
		
		if(!patientmail.equals(email)) {
			return false;
		}
		
		
		return true;
	}
	
	
	
	


public ResponseEntity<String> getDoctor(String email, String token) {

	boolean check=verifyTokenAndEmail(token,email);
	if(check==false) {
		return new ResponseEntity<String>("Authentication failed",HttpStatus.BAD_GATEWAY);
		
	}
	Patient p1=patientRepo.findFirstByEmail(email);
	
	String cityOfpatient=p1.getCity();
	
	City city1=City.DELHI;
	City city2=City.NOIDA;
	City city3=City.FARIDABAD;
	
			
	
	if(city1.name().equalsIgnoreCase(cityOfpatient)&&city2.name().equalsIgnoreCase(cityOfpatient)&&city3.name().equalsIgnoreCase(cityOfpatient)) {
		
		return new ResponseEntity<String>("We are still waiting to expand to your location",HttpStatus.OK);
	}
	
	HashMap<Symptom,Speciality>hm=new HashMap<>();
	
	hm.put(Symptom.ArthritisBackPain, Speciality.Orthopedic);
	hm.put(Symptom.Tissueinjuries, Speciality.Orthopedic);
	hm.put(Symptom.Dysmenorrhea, Speciality.Gynecology);
	hm.put(Symptom.Skininfection, Speciality.Dermatology);
	hm.put(Symptom.skinburn, Speciality.Dermatology);
	hm.put(Symptom.Earpain ,Speciality. ENT);
	hm.put(Symptom.BackPain , Speciality.Orthopedic);
	
	
	Symptom symptom=p1.getSymptom();
	
	Speciality speciality= hm.get(symptom);
	
	
	
	List<Doctor> listofDoctors=doctorRepo.findBySpeciality(speciality);
	
	if(listofDoctors==null) {
		
		return new ResponseEntity<String>("There isn’t any doctor present at your location for your symptom",HttpStatus.OK);}
	
	StringBuilder sb=new StringBuilder();
	for(Doctor dr:listofDoctors) {
		
	      String res=dr.getName()+" "+dr.getPhnumber()+" "+dr.getEmail()+"\n";
		
	      sb.append(res);
	}
	String ans=sb.toString();
	return new ResponseEntity<String>("Doctor avaiable are given below:"+"\n"+ans,HttpStatus.OK);
}


	
	
	
	
}
