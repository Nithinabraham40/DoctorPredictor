package com.tutorial.dr.model;

import java.time.LocalDate;
import java.util.UUID;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_authentication")
public class Authentication {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long auth_id;
	
	private String token;
	
	private LocalDate tokenCreationDate;
	@OneToOne
	@JoinColumn(name="fk_patientId")
	private Patient patient;
	
	
	public Authentication(Patient patient) {
	
		this.patient = patient;
		this.token=UUID.randomUUID().toString();
		this.tokenCreationDate=LocalDate.now();
		
	}}
