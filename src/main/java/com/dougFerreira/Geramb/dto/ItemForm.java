package com.dougFerreira.Geramb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ItemForm(
		
		@NotNull Long cabinet_id, @NotBlank String name, @NotNull Integer quantity
		
		) {

}
