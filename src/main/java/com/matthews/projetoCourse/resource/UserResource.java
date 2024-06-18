package com.matthews.projetoCourse.resource;

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
	
	@PostMapping
	public ResponseEntity<User> insertUser(@RequestBody User user){
		user = userServices.insertUser(user);
		return ResponseEntity.ok().body(user);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> atualizeUser(@PathVariable Long id, @RequestBody User user){
		user = userServices.atualizeUser(id, user);
		return ResponseEntity.ok().body(user);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userServices.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
