package com.dougFerreira.Geramb.services.studantClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.StudantClass;
import com.dougFerreira.Geramb.repositories.StudantClassRepository;

@Service
public class UpdateStudantClass {

	@Autowired
	private FindStudantClass findStudantClass;
	
	@Autowired
	private StudantClassRepository repository;
	
	public StudantClass update(Long id, Integer number, String name, String description, String technologialArea) {
		StudantClass studantClass = findStudantClass.findById(id);
		studantClass.setNumber(number);
		studantClass.setName(name);
		studantClass.setDescription(description);
		studantClass.setTechnologicalArea(technologialArea);
		return repository.save(studantClass);
	}
}
