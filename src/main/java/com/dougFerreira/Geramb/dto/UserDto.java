package com.dougFerreira.Geramb.dto;

import java.util.List;

import com.dougFerreira.Geramb.models.Profile;
import com.dougFerreira.Geramb.models.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {

	private Long id;
	
	private Long registration;
	
	private String name;
	
	private String email;
	
	private List<Profile> profiles;
	
	public UserDto(User user) {
		this.id = user.getId();
		this.registration = user.getRegistration();
		this.name = user.getName();
		this.email = user.getEmail().getAddress();
		this.profiles = user.getProfiles();
	}
}
