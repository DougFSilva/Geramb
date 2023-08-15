package com.dougFerreira.Geramb.models;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"date", "ambient_id"})})
public class Scheduling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate date;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ambient_id")
	private Ambient ambient;
	
	@Enumerated(EnumType.STRING)
	private Period period;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "studantClass_id")
	private StudantClass studantClass;
}
