package com.dougFerreira.Geramb.services.cabinet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.Ambient;
import com.dougFerreira.Geramb.models.Cabinet;
import com.dougFerreira.Geramb.repositories.CabinetRepository;
import com.dougFerreira.Geramb.services.ambient.FindAmbient;

@Service
public class CreateCabinet {

	@Autowired
	private FindAmbient findAmbient;

	@Autowired
	private CabinetRepository repository;

	public Cabinet create(Long ambient_id, String name, String localization, String description) {
		Ambient ambient = findAmbient.findById(ambient_id);
		Cabinet cabinet = new Cabinet(null, ambient, name, localization, description);
		return repository.save(cabinet);
	}
}
