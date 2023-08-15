package com.dougFerreira.Geramb.services.ambient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.Ambient;
import com.dougFerreira.Geramb.models.User;
import com.dougFerreira.Geramb.repositories.AmbientRepository;
import com.dougFerreira.Geramb.services.user.FindUser;

@Service
public class NominateResponsibleForTheAmbient {
	
	@Autowired
	private FindAmbient findAmbient;
	
	@Autowired
	private FindUser findUser;

	@Autowired
	private AmbientRepository repository;
	
	public Ambient nominate(Long id, Long registration) {
		Ambient ambient = findAmbient.findById(id);
		User user = findUser.findByRegistration(registration);
		ambient.setResponsible(user);
		return repository.save(ambient);
	}
}
