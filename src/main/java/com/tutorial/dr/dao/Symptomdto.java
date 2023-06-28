package com.tutorial.dr.dao;

import com.tutorial.dr.model.Symptom;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Symptomdto {

	@NotNull
	private Symptom symptom;
}
