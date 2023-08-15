package com.dougFerreira.Geramb.services.cabinet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.Exception.ObjectNotFoundException;
import com.dougFerreira.Geramb.models.Cabinet;
import com.dougFerreira.Geramb.repositories.CabinetRepository;

@Service
public class FindCabinet {

	@Autowired
	private CabinetRepository repository;
	
	public Cabinet findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(String.format("Armário com id %s não encontrado!", id)));
	}
	
	public List<Cabinet> findAllByNameContaining(String name) {
		return repository.findAllByNameContaining(name);
	}
	
	public List<Cabinet> findAllByAmbient(Long ambient_id) {
		return repository.findAllByAmbientId(ambient_id);
	}
	
	public List<Cabinet> findAll() {
		return repository.findAll();
	}
}
