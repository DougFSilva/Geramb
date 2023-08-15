package com.dougFerreira.Geramb.services.cabinet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.Cabinet;
import com.dougFerreira.Geramb.repositories.CabinetRepository;

@Service
public class DeleteCabinet {

	@Autowired
	private FindCabinet findCabinet;

	@Autowired
	private CabinetRepository repository;
	
	public void delete(Long id) {
		Cabinet cabinet = findCabinet.findById(id);
		repository.delete(cabinet);
	}
}
