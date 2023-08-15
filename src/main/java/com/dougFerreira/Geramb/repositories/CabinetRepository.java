package com.dougFerreira.Geramb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougFerreira.Geramb.models.Cabinet;

public interface CabinetRepository extends JpaRepository<Cabinet, Long> {

	List<Cabinet> findAllByAmbientId(Long ambient_id);

	List<Cabinet> findAllByNameContaining(String name);

}
