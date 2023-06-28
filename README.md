# Welcome to readme-md-generator &#x1F44B; 
![example workflow](https://img.shields.io/badge/Eclipse-Version%3A%202022--09%20(4.25.0)-orange)
![example workflow](https://img.shields.io/badge/SpringBoot-2.2.1-yellowgreen)
![example workflow](https://img.shields.io/badge/Java-8-yellowgreen)
![example workflow](https://img.shields.io/badge/Postman-v10.13-orange)
![example workflow](https://img.shields.io/badge/Documentation-Yes-green)
![example workflow](https://img.shields.io/badge/Manitained%3F-Yes-green)
 >CLI that generate beautiful **ReadME**.md files

  :house:  <b><span style="color: blue;">Homepage</span></b>
  


 # Prerequisties

 - **Eclipse >=4.55.0**
 - **Postman >=10.13**
 


# Install
```
Maven Install
SpringTool Install
```
 # Framework And Language

 - **Framework :  SpringBoot**
 - **Language :  Java**

 # Dependencies Required

 
 - **spring-boot-starter-web**
 - **spring-boot-devtools**
 - **spring-boot-starter-data-jpa**
 - **spring-boot-starter-validation**
 
 - **mysql-connector**
 - **lambok**
 - **jbcrypt**

 - **spring-boot-starter-test**
 


# Models Used



 - **Admin**
 -  **Authentication**
 -  **Doctor**
 -  **Patient**
 
  
 


	
	



#  Data flow

- **User send a request to ApI endpoint**
- **api forward it to the controller**
- **controller forward it to the Service layer**
- **service layer provide the necessary business logic and ask the repository for data**
- **Repository fetch the data from Mysql and give it back to service layer**
- **service layer give it to controller**
- **contoller give it to api**
- **Api give the response to user**


#  Api end points used at Admin Controller

- **adminadd/admin"**
- **admin/delete/doctor/{doctorid}/{email}**




#  Api end points used at Patient Controller

- **patient/signup**
-  **patient/signin**
-  **patient/addsymptom/{email}/{token}**
-   **patient/getDoctor/{email}/{token}**

-   **patient/signout/{email}/{token}**











# About my DroctorPredictor Project

 
🏥 My Doctor Predator project revolves around an administrator who holds the power to add and delete doctors from the database. Within this database, we store valuable information about doctors, including their city of practice and specialization. 🩺

👩‍⚕️ Patients can sign up and securely log in to the platform with robust authentication measures. Once logged in, they can effortlessly add their symptoms, and our algorithm will swiftly provide them with suitable doctor suggestions based on their symptoms and city of residence. 🩺💡

By combining the power of technology, expert medical knowledge, and seamless user experience, we strive to connect patients with the right doctors and facilitate efficient healthcare delivery. 🌟


#   Patient Controller
```
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
	@DeleteMapping("/signout/{email}/{token}")
	
	public ResponseEntity<String>signOut(@PathVariable("email") String email,@PathVariable("token") String token){
		
		return patientService.signOut(email,token);
		
	}
       
	
	
	
}
```











	
	


  



	



# DataBase Used


*Mysql*










  






# :handshake:  Contributing
  Contributions,issues and features request are welcome! 
  

  #


  This *README* was generated with &#x2764;&#xFE0F; by <b><span style="color: blue;">readme-md-generator</span></b> 
