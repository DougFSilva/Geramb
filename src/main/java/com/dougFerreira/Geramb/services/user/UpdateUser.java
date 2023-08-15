package com.dougFerreira.Geramb.services.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.Email;
import com.dougFerreira.Geramb.models.Profile;
import com.dougFerreira.Geramb.models.ProfileType;
import com.dougFerreira.Geramb.models.User;
import com.dougFerreira.Geramb.repositories.UserRepository;

@Service
public class UpdateUser {
	
	@Autowired
	private FindUser findUser;

	@Autowired
	private UserRepository repository;
	
	public User update(Long id, Long registration, String name, String email, List<ProfileType> profileTypes) {
		User user = findUser.findById(id);
		user.setRegistration(registration);
		user.setName(name);
		user.setEmail(new Email(email));
		List<Profile> profiles = profileTypes.stream().map(profileType -> new Profile(profileType)).collect(Collectors.toList());
		user.setProfiles(profiles);
		return repository.save(user);
	}
}
