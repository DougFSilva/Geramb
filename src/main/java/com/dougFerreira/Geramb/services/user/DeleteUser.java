package com.dougFerreira.Geramb.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.repositories.UserRepository;

@Service
public class DeleteUser {
	
	@Autowired
	private FindUser findUser;
	
	@Autowired
	private UserRepository repository;

	public void delete(Long id) {
		repository.delete(findUser.findById(id));
	}
}
