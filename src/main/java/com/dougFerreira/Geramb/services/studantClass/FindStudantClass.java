package com.dougFerreira.Geramb.services.studantClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.Exception.ObjectNotFoundException;
import com.dougFerreira.Geramb.models.StudantClass;
import com.dougFerreira.Geramb.repositories.StudantClassRepository;

@Service
public class FindStudantClass {

	@Autowired
	private StudantClassRepository repository;
	
	public StudantClass findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(String.format("Classe com id %s não encontrada!", id)));
	}
	
}
