package com.dougFerreira.Geramb.models;

import com.dougFerreira.Geramb.Exception.DataIntegrityViolationException;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Embeddable
public class Email {

	private String address;
	
	public Email(String address) {
		if (address == null || !address.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {

			throw new DataIntegrityViolationException(String.format("Email %s is not valid!", address));
		}
		this.address = address;
	}
	
	
}
