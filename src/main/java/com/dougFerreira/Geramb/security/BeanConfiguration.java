package com.dougFerreira.Geramb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dougFerreira.Geramb.models.PasswordEncoder;

@Configuration
public class BeanConfiguration {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BcryptEncoder();
	}
}
