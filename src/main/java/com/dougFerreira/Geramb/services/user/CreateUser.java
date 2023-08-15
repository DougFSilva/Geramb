package com.dougFerreira.Geramb.services.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.Email;
import com.dougFerreira.Geramb.models.PasswordEncoder;
import com.dougFerreira.Geramb.models.Profile;
import com.dougFerreira.Geramb.models.ProfileType;
import com.dougFerreira.Geramb.models.User;
import com.dougFerreira.Geramb.repositories.UserRepository;

@Service
public class CreateUser {

	@Autowired
	private PasswordEncoder passwordEncoder; 	
	
	@Autowired
	private UserRepository repository;
	
	public User create(Long registration, String name, String email, String password, List<ProfileType> profileTypes) {
		List<Profile> profiles = profileTypes.stream().map(profileType -> new Profile(profileType)).collect(Collectors.toList());
		String passwordEncoded = passwordEncoder.encode(password); 
		User user =  new User(null, registration, name, new Email(email), passwordEncoded, profiles);
		return repository.save(user);
	}
}
