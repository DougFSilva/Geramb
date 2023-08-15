package com.dougFerreira.Geramb.services.scheduling;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.Exception.OperationNotAllowedException;
import com.dougFerreira.Geramb.models.Ambient;
import com.dougFerreira.Geramb.models.Period;
import com.dougFerreira.Geramb.models.Scheduling;
import com.dougFerreira.Geramb.models.StudantClass;
import com.dougFerreira.Geramb.repositories.SchedulingRepository;
import com.dougFerreira.Geramb.services.ambient.FindAmbient;
import com.dougFerreira.Geramb.services.studantClass.FindStudantClass;

@Service
public class CreateScheduling {

	@Autowired
	private SchedulingRepository repository;
	
	@Autowired
	private FindAmbient findAmbient;
	
	@Autowired
	private FindStudantClass findStudantClass;
	
	@Autowired
	private FindScheduling findScheduling;
	
	public Scheduling create(LocalDate date, Long ambient_id, Period period, Long studantClass_id) {
		Optional<Scheduling> existingScheduling = findScheduling.findExisting(date, ambient_id, period);
		if(existingScheduling.isPresent()) {
			throw new OperationNotAllowedException("Agendamento existente!");
		}
		Ambient ambient = findAmbient.findById(ambient_id);
		StudantClass studantClass = findStudantClass.findById(studantClass_id);
		Scheduling scheduling = new Scheduling(null, date, ambient, period, studantClass);
		return repository.save(scheduling);
	}
}
