package com.dougFerreira.Geramb.services.ambient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.Ambient;
import com.dougFerreira.Geramb.repositories.AmbientRepository;

@Service
public class DeleteAmbient {

	@Autowired
	private FindAmbient findAmbient;
	
	@Autowired
	private AmbientRepository repository;
	
	public void delete(Long id) {
		Ambient ambient = findAmbient.findById(id);
		repository.delete(ambient);
	}
}
