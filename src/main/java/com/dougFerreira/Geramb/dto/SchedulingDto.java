package com.dougFerreira.Geramb.dto;

import java.time.LocalDate;

import com.dougFerreira.Geramb.models.Period;
import com.dougFerreira.Geramb.models.Scheduling;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SchedulingDto {

	private Long id;
	
	private LocalDate date;
	
	private String ambient;
	
	private Period period;
	
	private String studantClass;
	
	public SchedulingDto(Scheduling scheduling) {
		this.id = scheduling.getId();
		this.date = scheduling.getDate();
		this.ambient = scheduling.getAmbient().getName();
		this.period = scheduling.getPeriod();
		this.studantClass = scheduling.getStudantClass().getName();
	}
}
