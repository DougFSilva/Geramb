package com.dougFerreira.Geramb.dto;

import java.time.LocalDate;

import com.dougFerreira.Geramb.models.Period;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SchedulingForm(
		
		@NotNull LocalDate date,
		
		@NotNull Long ambient_id,
		
		@NotBlank Period period,
		
		@NotNull Long studantClass_id
		
		) {

}
