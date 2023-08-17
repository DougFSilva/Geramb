package com.dougFerreira.Geramb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CabinetForm(
		
		@NotNull Long ambient_id, @NotBlank String name, @NotBlank String localization, @NotBlank String description 
		) {

}
