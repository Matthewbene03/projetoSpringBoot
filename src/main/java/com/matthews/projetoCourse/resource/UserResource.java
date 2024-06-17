package com.matthews.projetoCourse.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matthews.projetoCourse.entidades.User;
import com.matthews.projetoCourse.services.UserServices;

@RestController
@RequestMapping(value = "/user") //Caminho para buscar na web
public class UserResource { //Apartir dessa classe que dar uma resposta para a web. Conseguindo mostrar na tela. 
	
	@Autowired
	private UserServices userServices;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){ //Usa esse metodo para retornar uma resposta para a pagina web.
		List<User> listUser = userServices.findAll();
		return ResponseEntity.ok().body(listUser);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userServices.findById(id);
		return ResponseEntity.ok().body(user);
	}
}
