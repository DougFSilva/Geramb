package com.dougFerreira.Geramb.services.cabinet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.Ambient;
import com.dougFerreira.Geramb.models.Cabinet;
import com.dougFerreira.Geramb.repositories.CabinetRepository;
import com.dougFerreira.Geramb.services.ambient.FindAmbient;

@Service
public class UpdateCabinet {

	@Autowired
	private FindCabinet findCabinet;
	
	@Autowired
	private FindAmbient findAmbient;

	@Autowired
	private CabinetRepository repository;
	
	public Cabinet update(Long id, Long ambient_id, String name, String localization, String description) {
		Cabinet cabinet = findCabinet.findById(id);
		Ambient ambient = findAmbient.findById(ambient_id);
		cabinet.setAmbient(ambient);
		cabinet.setName(name);
		cabinet.setLocalization(localization);
		cabinet.setDescription(description);
		return repository.save(cabinet);
	}
}
