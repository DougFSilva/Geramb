package com.dougFerreira.Geramb.controllers;

import java.net.URI;

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

import com.dougFerreira.Geramb.dto.SchedulingDto;
import com.dougFerreira.Geramb.dto.SchedulingForm;
import com.dougFerreira.Geramb.models.Scheduling;
import com.dougFerreira.Geramb.services.scheduling.CreateScheduling;
import com.dougFerreira.Geramb.services.scheduling.DeleteScheduling;
import com.dougFerreira.Geramb.services.scheduling.FindScheduling;
import com.dougFerreira.Geramb.services.scheduling.UpdateScheduling;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {

	@Autowired
	private CreateScheduling createScheduling;
	
	@Autowired
	private DeleteScheduling deleteScheduling;
	
	@Autowired
	private UpdateScheduling updateScheduling;
	
	@Autowired
	private FindScheduling findScheduling;
	
	@PostMapping
	public ResponseEntity<Scheduling> createScheduling(@RequestBody @Valid SchedulingForm form){
		Scheduling scheduling = createScheduling.create(form.date(), form.ambient_id(), form.period(), form.studantClass_id());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(scheduling.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteScheduling(@PathVariable Long id){
		deleteScheduling.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SchedulingDto> updateScheduling(@RequestBody @Valid SchedulingForm form, @PathVariable Long id){
		Scheduling scheduling = updateScheduling.update(id, form.date(), form.ambient_id(), form.period(), form.studantClass_id());
		return ResponseEntity.ok().body(new SchedulingDto(scheduling));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SchedulingDto> findSchedulingById(@PathVariable Long id){
		Scheduling scheduling = findScheduling.findById(id);
		return ResponseEntity.ok().body(new SchedulingDto(scheduling));
	}
}
