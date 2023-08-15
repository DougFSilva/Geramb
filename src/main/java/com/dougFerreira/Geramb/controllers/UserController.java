package com.dougFerreira.Geramb.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.dougFerreira.Geramb.dto.CreateUserForm;
import com.dougFerreira.Geramb.dto.UpdateUserForm;
import com.dougFerreira.Geramb.dto.UserDto;
import com.dougFerreira.Geramb.models.User;
import com.dougFerreira.Geramb.services.user.CreateUser;
import com.dougFerreira.Geramb.services.user.DeleteUser;
import com.dougFerreira.Geramb.services.user.FindUser;
import com.dougFerreira.Geramb.services.user.UpdateUser;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private CreateUser createUser;
	
	@Autowired
	private DeleteUser deleteUser;
	
	@Autowired
	private UpdateUser updateUser;
	
	@Autowired
	private FindUser findUser;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserForm form){
		User newUser = createUser.create(form.registration(), form.name(), form.email(), form.password(), form.profileTypes());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id){
		deleteUser.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UpdateUserForm form, @PathVariable Long id) {
		User userUpdated = updateUser.update(id, form.registration(), form.name(), form.email(), form.profileTypes());
		return ResponseEntity.ok().body(new UserDto(userUpdated));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> findUserById(@PathVariable Long id) {
		User user = findUser.findById(id);
		return ResponseEntity.ok().body(new UserDto(user));
	}
	
	@GetMapping("/registration/{registration}")
	public ResponseEntity<UserDto> findUserByRegistration(@PathVariable Long registration) {
		User user = findUser.findByRegistration(registration);
		return ResponseEntity.ok().body(new UserDto(user));
	}
	
	@GetMapping
	public ResponseEntity<Page<UserDto>> findAllUsers(Pageable pageable){
		Page<User> users = findUser.findAll(pageable);
		Page<UserDto> usersDto = users.map(user -> new UserDto(user));
		return ResponseEntity.ok(usersDto);
	}
	
}
