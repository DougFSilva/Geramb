package com.dougFerreira.Geramb.services.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.Cabinet;
import com.dougFerreira.Geramb.models.Item;
import com.dougFerreira.Geramb.repositories.ItemRepository;
import com.dougFerreira.Geramb.services.cabinet.FindCabinet;

@Service
public class UpdateItem {

	@Autowired
	private FindItem findItem;
	
	@Autowired
	private FindCabinet findCabinet;
	
	@Autowired
	private ItemRepository repository;
	
	public Item update(Long id, Long cabinet_id, String name, Integer quantity) {
		Item item = findItem.findById(id);
		Cabinet cabinet = findCabinet.findById(cabinet_id);
		item.setCabinet(cabinet);
		item.setName(name);
		item.setQuantity(quantity);
		return repository.save(item);
	}
}
