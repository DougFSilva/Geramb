package com.dougFerreira.Geramb.services.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.Item;
import com.dougFerreira.Geramb.repositories.ItemRepository;

@Service
public class DeleteItem {

	@Autowired
	private FindItem findItem;
	
	@Autowired
	private ItemRepository repository;
	
	public void delete(Long id) {
		Item item = findItem.findById(id);
		repository.delete(item);
	}
}
