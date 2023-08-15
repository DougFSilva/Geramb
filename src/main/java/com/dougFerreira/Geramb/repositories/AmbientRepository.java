package com.dougFerreira.Geramb.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dougFerreira.Geramb.models.Ambient;

public interface AmbientRepository extends JpaRepository<Ambient, Long> {

	List<Ambient> findAllByNameContaining(String name);

}
