package com.dougFerreira.Geramb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougFerreira.Geramb.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

	List<Item> findAllByCabinetId(Long id);

	List<Item> findAllByNameContaining(String name);

}
