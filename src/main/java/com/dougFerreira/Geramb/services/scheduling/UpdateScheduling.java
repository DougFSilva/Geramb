package com.dougFerreira.Geramb.services.scheduling;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.Ambient;
import com.dougFerreira.Geramb.models.Period;
import com.dougFerreira.Geramb.models.Scheduling;
import com.dougFerreira.Geramb.models.StudantClass;
import com.dougFerreira.Geramb.repositories.SchedulingRepository;
import com.dougFerreira.Geramb.services.ambient.FindAmbient;
import com.dougFerreira.Geramb.services.studantClass.FindStudantClass;

@Service
public class UpdateScheduling {

	@Autowired
	private FindScheduling findScheduling;
	
	@Autowired
	private FindAmbient findAmbient;
	
	@Autowired
	private FindStudantClass findStudantClass;
	
	@Autowired
	private SchedulingRepository repository;
	
	public Scheduling update(Long id, LocalDate date, Long ambient_id, Period period, Long studantClass_id ) {
		Scheduling scheduling = findScheduling.findById(id);
		Ambient ambient = findAmbient.findById(ambient_id);
		StudantClass studantClass = findStudantClass.findById(studantClass_id);
		scheduling.setDate(date);
		scheduling.setAmbient(ambient);
		scheduling.setPeriod(period);
		scheduling.setStudantClass(studantClass);
		return repository.save(scheduling);
	}
}
