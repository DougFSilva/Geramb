package com.dougFerreira.Geramb.services.ambient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.Ambient;
import com.dougFerreira.Geramb.repositories.AmbientRepository;

@Service
public class CreateAmbient {

	@Autowired
	private AmbientRepository repository;
	
	public Ambient create(String name, String localization, String description) {
		Ambient ambient = new Ambient(name, localization, description);
		return repository.save(ambient);
	}
}
