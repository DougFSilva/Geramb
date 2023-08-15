package com.dougFerreira.Geramb.dto;

import com.dougFerreira.Geramb.models.Ambient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AmbientDto {
	
	private Long id;
	
	private String name;
	
	private String localization;
	
	private String description;
	
	private String responsible;
	

	public AmbientDto(Ambient ambient) {
		this.id = ambient.getId();
		this.name = ambient.getName();
		this.localization = ambient.getLocalization();
		this.description = ambient.getDescription();
		if(ambient.getResponsible() != null) {
			this.responsible = ambient.getResponsible().getName() + " - " + ambient.getResponsible().getRegistration();
		}else {
			this.responsible = "Sem responsável";
		}
		
	}
	
}
