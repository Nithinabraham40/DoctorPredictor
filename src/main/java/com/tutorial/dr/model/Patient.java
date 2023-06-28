package com.tutorial.dr.model;

import java.util.ArrayList;

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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(max = 50,message = "size should be less than 50 character")
	private String name;
	@NotNull
	@Email
	private String email;
	@NotNull
	@Pattern(regexp = "\\d{10}", message = "Invalid phone number. Must be a 10-digit number.")
	private String phnumber;
	@NotNull
	@Size(max = 20,message = "size should be less than 50 character")
	private String city;
	@NotNull
	private String password;
   @Enumerated(EnumType.STRING)
	private Symptom symptom;


}
