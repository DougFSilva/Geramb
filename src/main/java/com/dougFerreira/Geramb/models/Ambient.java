package com.dougFerreira.Geramb.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString(of = {"id", "name", "description"})
@Entity
public class Ambient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String localization;
	
	private String description;
	
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	private User responsible;
	
	public Ambient(String name, String localization, String description) {
		this.name = name;
		this.localization = localization;
		this.description = description;
	}
	
		
}
