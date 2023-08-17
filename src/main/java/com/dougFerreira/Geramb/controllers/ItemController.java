package com.dougFerreira.Geramb.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dougFerreira.Geramb.dto.ItemDto;
import com.dougFerreira.Geramb.dto.ItemForm;
import com.dougFerreira.Geramb.models.Item;
import com.dougFerreira.Geramb.services.item.CreateItem;
import com.dougFerreira.Geramb.services.item.DeleteItem;
import com.dougFerreira.Geramb.services.item.FindItem;
import com.dougFerreira.Geramb.services.item.UpdateImageItem;
import com.dougFerreira.Geramb.services.item.UpdateItem;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private CreateItem createItem;
	
	@Autowired
	private DeleteItem deleteItem;
	
	@Autowired
	private UpdateItem updateItem;
	
	@Autowired
	private FindItem findItem;
	
	@Autowired
	private UpdateImageItem updateImageItem;
	
	@PostMapping
	public ResponseEntity<Item> createItem(@RequestBody @Valid ItemForm form) {
		Item item = createItem.create(form.cabinet_id(), form.name(), form.quantity());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(item.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable Long id){
		deleteItem.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemDto> updateItem(@RequestBody @Valid ItemForm form, @PathVariable Long id){
		Item item = updateItem.update(id, form.cabinet_id(), form.name(), form.quantity());
		return ResponseEntity.ok().body(new ItemDto(item));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemDto> findItemById(@PathVariable Long id){
		Item item = findItem.findById(id);
		return ResponseEntity.ok().body(new ItemDto(item));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<ItemDto>> findAllItensByNameContainig(@PathVariable String name){
		List<ItemDto> itens = findItem.findAllByNameContaining(name)
				.stream()
				.map(item -> new ItemDto(item))
				.toList();
		return ResponseEntity.ok().body(itens);
	}
	
	@GetMapping("/cabinet/{cabinet}")
	public ResponseEntity<List<ItemDto>> findAllItensByCabinet(@PathVariable Long cabinet){
		List<ItemDto> itens = findItem.findAllByCabinet(cabinet)
				.stream()
				.map(item -> new ItemDto(item))
				.toList();
		return ResponseEntity.ok().body(itens);
	}
	
	@GetMapping
	public ResponseEntity<List<ItemDto>> findAllItens(){
		List<ItemDto> itens = findItem.findAll()
				.stream()
				.map(item -> new ItemDto(item))
				.toList();
		return ResponseEntity.ok().body(itens);
	}
	
	
}
