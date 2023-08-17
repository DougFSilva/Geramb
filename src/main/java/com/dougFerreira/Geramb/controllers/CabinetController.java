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

import com.dougFerreira.Geramb.dto.CabinetDto;
import com.dougFerreira.Geramb.dto.CabinetForm;
import com.dougFerreira.Geramb.models.Cabinet;
import com.dougFerreira.Geramb.services.cabinet.CreateCabinet;
import com.dougFerreira.Geramb.services.cabinet.DeleteCabinet;
import com.dougFerreira.Geramb.services.cabinet.FindCabinet;
import com.dougFerreira.Geramb.services.cabinet.UpdateCabinet;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cabinet")
public class CabinetController {

	@Autowired
	private CreateCabinet createCabinet;
	
	@Autowired
	private DeleteCabinet deleteCabinet;
	
	@Autowired
	private UpdateCabinet updateCabinet;
	
	@Autowired
	private FindCabinet findCabinet;
	
	@PostMapping
	public ResponseEntity<Cabinet> createCabinet(@RequestBody @Valid CabinetForm form){
		Cabinet cabinet = createCabinet.create(form.ambient_id(), form.name(), form.localization(), form.description());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cabinet.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCabinet(@PathVariable Long id){
		deleteCabinet.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CabinetDto> updateCabinet(@RequestBody @Valid CabinetForm form, @PathVariable Long id) {
		Cabinet cabinet = updateCabinet.update(id, form.ambient_id(), form.name(), form.localization(), form.description());
		return ResponseEntity.ok().body(new CabinetDto(cabinet));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CabinetDto> findCabinetById(@PathVariable Long id){
		Cabinet cabinet = findCabinet.findById(id);
		return ResponseEntity.ok().body(new CabinetDto(cabinet));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<CabinetDto>> findAllCabinetsByNameContaining(@PathVariable String name){
		List<CabinetDto> cabinets = findCabinet.findAllByNameContaining(name)
				.stream()
				.map(cabinet -> new CabinetDto(cabinet))
				.toList();;
		return ResponseEntity.ok().body(cabinets);
	}
	
	@GetMapping("/ambient/{ambient_id}")
	public ResponseEntity<List<CabinetDto>> findAllCabinetsByAmbient(@PathVariable Long ambient_id){
		List<CabinetDto> cabinets  = findCabinet.findAllByAmbient(ambient_id).stream()
				.map(cabinet -> new CabinetDto(cabinet))
				.toList();;
		return ResponseEntity.ok().body(cabinets);
	}
	
	@GetMapping
	public ResponseEntity<List<CabinetDto>> findAllCabinets(){
		List<CabinetDto> cabinets = findCabinet.findAll()
				.stream()
				.map(cabinet -> new CabinetDto(cabinet))
				.toList();
		return ResponseEntity.ok().body(cabinets);
	}
	
}
