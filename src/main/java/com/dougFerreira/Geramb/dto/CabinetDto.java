package com.dougFerreira.Geramb.dto;

import com.dougFerreira.Geramb.models.Cabinet;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CabinetDto {

	private Long id;
	
	private String ambient;
	
	private String name;
	
	private String localization;
	
	private String description;
	
	public CabinetDto(Cabinet cabinet) {
		this.id = cabinet.getId();
		this.ambient = cabinet.getAmbient().getName();
		this.name = cabinet.getName();
		this.localization = cabinet.getLocalization();
		this.description = cabinet.getDescription();
	}
}
