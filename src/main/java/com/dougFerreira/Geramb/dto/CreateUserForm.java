package com.dougFerreira.Geramb.dto;

import java.util.List;

import com.dougFerreira.Geramb.models.ProfileType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserForm(
		
		@NotNull Long registration, @NotBlank String name, String email, @NotBlank String password, @NotNull List<ProfileType> profileTypes
		
		) {

}
