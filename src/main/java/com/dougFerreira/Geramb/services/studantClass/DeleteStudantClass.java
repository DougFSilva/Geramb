package com.dougFerreira.Geramb.services.studantClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.StudantClass;
import com.dougFerreira.Geramb.repositories.StudantClassRepository;

@Service
public class DeleteStudantClass {

	@Autowired
	private FindStudantClass findStudantClass;
	
	@Autowired
	private StudantClassRepository repository;
	
	public void delete(Long id) {
		StudantClass studantClass = findStudantClass.findById(id);
		repository.delete(studantClass);
	}
}
