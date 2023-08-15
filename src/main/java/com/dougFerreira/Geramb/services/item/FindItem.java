package com.dougFerreira.Geramb.services.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.Exception.ObjectNotFoundException;
import com.dougFerreira.Geramb.models.Item;
import com.dougFerreira.Geramb.repositories.ItemRepository;

@Service
public class FindItem {

	@Autowired
	private ItemRepository repository;
	
	public Item findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(String.format("Item com id %s não encontrado!", id)));
	}
	
	public List<Item> findAllByNameContaining(String name) {
		return repository.findAllByNameContaining(name);
	}
	
	public List<Item> findByCabinet(Long id) {
		return repository.findAllByCabinetId(id);
	}
	
	public List<Item> findByAll() {
		return repository.findAll();
	}
}
