package com.dougFerreira.Geramb.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougFerreira.Geramb.models.Period;
import com.dougFerreira.Geramb.models.Scheduling;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {

	Optional<Scheduling> findByDateAndAmbient_idAndPeriod(LocalDate date, Long ambient_id, Period period);

	List<Scheduling> findAllByDate(LocalDate date);

	List<Scheduling> findAllByAmbient_id(Long id);

	List<Scheduling> findAllByDateBetween(LocalDate initialDate, LocalDate finalDate);

	List<Scheduling> findAllByStudantClass_id(Long studantClass_id);


}
