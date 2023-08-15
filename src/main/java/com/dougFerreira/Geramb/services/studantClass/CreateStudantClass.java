package com.dougFerreira.Geramb.services.studantClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.StudantClass;
import com.dougFerreira.Geramb.repositories.StudantClassRepository;

@Service
public class CreateStudantClass {

	@Autowired
	private StudantClassRepository repository;
	
	public StudantClass create(Integer number, String name, String description, String technologialArea) {
		StudantClass studantClass = new StudantClass(null, number, name, description, technologialArea);
		return repository.save(studantClass);
	}
}
