package com.dougFerreira.Geramb.services.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dougFerreira.Geramb.models.Item;
import com.dougFerreira.Geramb.repositories.ItemRepository;

@Service
public class UpdateImageItem {

	@Autowired
	private FindItem findItem;
	
	@Autowired
	private ItemRepository repository;
	
	public void update(Long id, String image) {
		Item item = findItem.findById(id);
		item.setImage(image);
		repository.save(item);
	}
}
