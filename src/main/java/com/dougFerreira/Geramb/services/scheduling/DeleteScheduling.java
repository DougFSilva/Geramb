package com.dougFerreira.Geramb.services.scheduling;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.Scheduling;
import com.dougFerreira.Geramb.repositories.SchedulingRepository;

@Service
public class DeleteScheduling {

	@Autowired
	private FindScheduling findScheduling;
	
	@Autowired
	private SchedulingRepository repository;
	
	public void delete(Long id) {
		Scheduling scheduling = findScheduling.findById(id);
		repository.delete(scheduling);
	}
	
	public void deletByDate(LocalDate date) {
		
	}
	
}
