package com.dougFerreira.Geramb.dto;

import jakarta.validation.constraints.NotBlank;

public record AmbientForm(
		
		@NotBlank String name, @NotBlank String localization, String description
		
		) {

}
