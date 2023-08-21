package com.dougFerreira.Geramb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudantClassForm(
		
		 @NotNull Integer number,
		
		 @NotBlank String name,
		 
		 @NotBlank String description,
		
		 @NotBlank String technologicalArea
		) {

}
