package com.matthews.projetoCourse.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matthews.projetoCourse.entidades.User;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(1L, "Matheus", "matheus@gmail.com", "31989051685", "73532423");
		return ResponseEntity.ok().body(user);
	}
}
