package com.dougFerreira.Geramb.services.ambient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.Ambient;
import com.dougFerreira.Geramb.repositories.AmbientRepository;

@Service
public class UpdateAmbiente {
	
	@Autowired
	private FindAmbient findAmbient;

	@Autowired
	private AmbientRepository repository;
	
	
	public Ambient update(Long id, String name, String localization, String description) {
		Ambient ambient = findAmbient.findById(id);
		ambient.setName(name);
		ambient.setLocalization(localization);
		ambient.setDescription(description);
		return repository.save(ambient);
	}
}
