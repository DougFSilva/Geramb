package com.dougFerreira.Geramb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougFerreira.Geramb.models.StudantClass;

public interface StudantClassRepository extends JpaRepository<StudantClass, Long>{

	List<StudantClass> findAllByNameContaining(String name);

}
