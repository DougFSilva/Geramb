package com.dougFerreira.Geramb.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.Exception.ObjectNotFoundException;
import com.dougFerreira.Geramb.models.User;
import com.dougFerreira.Geramb.repositories.UserRepository;

@Service
public class FindUser {

	@Autowired
	private UserRepository repository;
	
	public User findById(Long id){
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(String.format("Usuário com id %s não encontrado!", id)));
	}
	
	public User findByRegistration(Long registration) {
		return repository.findAllByRegistration(registration);
	}
	
	public Page<User> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
