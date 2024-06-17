package com.matthews.projetoCourse.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matthews.projetoCourse.entidades.User;

@RestController
@RequestMapping(value = "/user") //Caminho para buscar na web
public class UserResource { //Apartir dessa classe que dar uma resposta para a web. Conseguindo mostrar na tela. 
	
	@GetMapping
	public ResponseEntity<User> findAll(){ //Usa esse metodo para retornar uma resposta para a pagina web.
		User user = new User(1L, "Matheus", "matheus@gmail.com", "31989051685", "73532423");
		return ResponseEntity.ok().body(user);
	}
}
