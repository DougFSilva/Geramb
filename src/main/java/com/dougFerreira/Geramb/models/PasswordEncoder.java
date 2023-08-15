package com.dougFerreira.Geramb.models;

public interface PasswordEncoder {

	String encode(String password);
	
	boolean compare(String rawPassword, String password);
}
