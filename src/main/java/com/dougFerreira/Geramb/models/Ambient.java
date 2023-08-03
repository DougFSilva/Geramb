package com.dougFerreira.Geramb.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString(of = {"id", "name", "description"})
public class Ambient {

	private Long id;
	
	private String name;
	
	private String description;
	
	
}
