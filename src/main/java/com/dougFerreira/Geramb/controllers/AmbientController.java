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

import com.dougFerreira.Geramb.dto.AmbientDto;
import com.dougFerreira.Geramb.dto.AmbientForm;
import com.dougFerreira.Geramb.models.Ambient;
import com.dougFerreira.Geramb.services.ambient.CreateAmbient;
import com.dougFerreira.Geramb.services.ambient.DeleteAmbient;
import com.dougFerreira.Geramb.services.ambient.FindAmbient;
import com.dougFerreira.Geramb.services.ambient.NominateResponsibleForTheAmbient;
import com.dougFerreira.Geramb.services.ambient.UpdateAmbiente;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ambient")
public class AmbientController {

	@Autowired
	private CreateAmbient createAmbient;
	
	@Autowired
	private DeleteAmbient deleteAmbient;
	
	@Autowired
	private UpdateAmbiente updateAmbiente;
	
	@Autowired
	private FindAmbient findAmbient;
	
	@Autowired
	private NominateResponsibleForTheAmbient nominateResponsibleForTheAmbient;
	
	@PostMapping
	public ResponseEntity<Ambient> createAmbient(@RequestBody @Valid AmbientForm form) {
		Ambient ambient = createAmbient.create(form.name(), form.localization(), form.description());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ambient.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAmbient(Long id) {
		deleteAmbient.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AmbientDto> updateAmbient(@RequestBody @Valid AmbientForm form, @PathVariable Long id) {
		Ambient ambientUpdated = updateAmbiente.update(id, form.name(), form.localization(), form.description());
		return ResponseEntity.ok().body(new AmbientDto(ambientUpdated));
	}
	
	@PutMapping("/{id}/responsible/{registration}")
	public ResponseEntity<AmbientDto> NominateResponsibleForTheAmbient(@PathVariable Long id, @PathVariable Long registration) {
		Ambient ambient = nominateResponsibleForTheAmbient.nominate(id, registration);
		return ResponseEntity.ok().body(new AmbientDto(ambient));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AmbientDto> findAmbientById(@PathVariable Long id){
		Ambient ambient = findAmbient.findById(id);
		return ResponseEntity.ok().body(new AmbientDto(ambient));
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<List<AmbientDto>> findAmbientByNameContaining(@PathVariable String name){
		List<Ambient> ambients = findAmbient.findByNameContaining(name);
		List<AmbientDto> ambinetsDto = ambients.stream().map(ambient -> new AmbientDto(ambient)).toList();
		return ResponseEntity.ok().body(ambinetsDto);
	}
	
	@GetMapping
	public ResponseEntity<List<Ambient>> findllAmbients(){
		List<Ambient> ambients = findAmbient.findAll();
		return ResponseEntity.ok().body(ambients);
	}
	
	
}
