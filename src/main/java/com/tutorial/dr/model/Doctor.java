package com.tutorial.dr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 3, message = "Name must be at least 3 characters long.")
	private String name;
	@NotNull
	@Email
	private String email;
	@Pattern(regexp = "\\d{10}", message = "Invalid phone number. Must be a 10-digit number.")
	private String phnumber;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private City city;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Speciality speciality;
	

}
