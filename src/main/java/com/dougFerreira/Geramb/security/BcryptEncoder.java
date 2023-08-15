package com.dougFerreira.Geramb.security;

import com.dougFerreira.Geramb.models.PasswordEncoder;

public class BcryptEncoder implements PasswordEncoder{

	@Override
	public String encode(String password) {
		return null;
	}

	@Override
	public boolean compare(String rawPassword, String password) {
		return false;
	}

}
