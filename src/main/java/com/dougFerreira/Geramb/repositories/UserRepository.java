package com.dougFerreira.Geramb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougFerreira.Geramb.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findAllByRegistration(Long registration);

}
