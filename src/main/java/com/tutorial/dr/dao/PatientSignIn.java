package com.tutorial.dr.dao;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientSignIn {

	@NotNull
	private String email;
	@NotNull
	private String password;
}
