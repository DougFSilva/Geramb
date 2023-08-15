package com.dougFerreira.Geramb.services.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.Cabinet;
import com.dougFerreira.Geramb.models.Item;
import com.dougFerreira.Geramb.repositories.ItemRepository;
import com.dougFerreira.Geramb.services.cabinet.FindCabinet;

@Service
public class CreateItem {
	
	@Autowired
	private FindCabinet findCabinet;

	@Autowired
	private ItemRepository repository;
	
	public Item create(Long cabinet_id, String name, Integer quantity ) { 
		Cabinet cabinet = findCabinet.findById(cabinet_id);
		Item item = new Item(null, cabinet, name, quantity, "");
		return repository.save(item);
	}
	
}
