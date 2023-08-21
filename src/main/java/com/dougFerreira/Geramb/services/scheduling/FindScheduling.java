package com.dougFerreira.Geramb.services.scheduling;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.Exception.ObjectNotFoundException;
import com.dougFerreira.Geramb.models.Period;
import com.dougFerreira.Geramb.models.Scheduling;
import com.dougFerreira.Geramb.repositories.SchedulingRepository;

@Service
public class FindScheduling {

	@Autowired
	private SchedulingRepository repository;

	public Scheduling findById(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new ObjectNotFoundException(String.format("Agendamento com id %s não encontrado!", id)));
	}                         
	
	public Optional<Scheduling> findExisting(LocalDate date, Long ambient_id, Period period) {
		return repository.findByDateAndAmbient_idAndPeriod(date, ambient_id, period);
	}  
	
	public List<Scheduling> findByDate(LocalDate date){
		return repository.findAllByDate(date);
	}
	
	public List<Scheduling> findByDate(LocalDate initialDate, LocalDate finalDate){
		return repository.findAllByDateBetween(initialDate, finalDate);
	}
	
	public List<Scheduling> findByAmbient(Long ambient_id) {
		return repository.findAllByAmbient_id(ambient_id);
	}
	
	public List<Scheduling> findByStudentClass(Long studantClass_id) {
		return repository.findAllByStudantClass_id(studantClass_id);
	}
}
