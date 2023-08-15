package com.dougFerreira.Geramb.services.scheduling;

import java.time.LocalDate;
import java.util.List;

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
		List<Scheduling> schedulings = findScheduling.findByDate(date);
		repository.deleteAll(schedulings);
	}
	
	public void deletByDate(LocalDate initialDate, LocalDate finalDate) {
		List<Scheduling> schedulings = findScheduling.findByDate(initialDate, finalDate);
		repository.deleteAll(schedulings);
	}
	
	public void deleteByAmbient(Long ambient_id) {
		List<Scheduling> schedulings = findScheduling.findByAmbient(ambient_id);
		repository.deleteAll(schedulings);
	}
	
	public void deleteByStudentClass(Long studantClass_id) {
		List<Scheduling> schedulings = findScheduling.findByStudentClass(studantClass_id);
		repository.deleteAll(schedulings);
	}
	
}
