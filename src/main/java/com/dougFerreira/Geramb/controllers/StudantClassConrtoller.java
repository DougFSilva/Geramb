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

import com.dougFerreira.Geramb.dto.StudantClassForm;
import com.dougFerreira.Geramb.models.StudantClass;
import com.dougFerreira.Geramb.services.studantClass.CreateStudantClass;
import com.dougFerreira.Geramb.services.studantClass.DeleteStudantClass;
import com.dougFerreira.Geramb.services.studantClass.FindStudantClass;
import com.dougFerreira.Geramb.services.studantClass.UpdateStudantClass;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/class")
public class StudantClassConrtoller {

	@Autowired
	private CreateStudantClass createStudantClass;
	
	@Autowired
	private DeleteStudantClass deleteStudantClass;
	
	@Autowired
	private UpdateStudantClass updateStudantClass;
	
	@Autowired
	private FindStudantClass findStudantClass;
	
	@PostMapping
	public ResponseEntity<StudantClass> createStudantClass(@RequestBody @Valid StudantClassForm form){
		StudantClass clazz = createStudantClass.create(form.number(), form.name(), form.description(), form.technologicalArea());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clazz.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudantClass(@PathVariable Long id){
		deleteStudantClass.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StudantClass> updateStudantClass(@RequestBody @Valid StudantClassForm form, @PathVariable Long id){
		StudantClass clazz = updateStudantClass.update(id, form.number(), form.name(), form.description(), form.technologicalArea());
		return ResponseEntity.ok().body(clazz);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudantClass> findStudantClassById(@PathVariable Long id){
		StudantClass clazz = findStudantClass.findById(id);
		return ResponseEntity.ok().body(clazz);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<StudantClass>> findAllStudantClassByNameContaining(@PathVariable String name){
		List<StudantClass> clazz = findStudantClass.findAllByNameContaining(name);
		return ResponseEntity.ok().body(clazz);
	}
	
	@GetMapping
	public ResponseEntity<List<StudantClass>> findAll(){
		List<StudantClass> clazz = findStudantClass.findAll();
		return ResponseEntity.ok().body(clazz);
	}
}
