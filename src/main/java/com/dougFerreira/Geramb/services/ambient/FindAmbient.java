package com.dougFerreira.Geramb.services.ambient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.Exception.ObjectNotFoundException;
import com.dougFerreira.Geramb.models.Ambient;
import com.dougFerreira.Geramb.repositories.AmbientRepository;

@Service
public class FindAmbient {

	@Autowired
	private AmbientRepository repository;
	
	public Ambient findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(String.format("Ambiente com id %s não encontrado!", id)));
	}
	
	public List<Ambient> findByNameContaining(String name) {
		return repository.findAllByNameContaining(name);
	}
	
	public List<Ambient> findAll() {
		return repository.findAll();
	}
}
