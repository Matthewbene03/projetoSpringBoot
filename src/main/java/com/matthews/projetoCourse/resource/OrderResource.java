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

import com.matthews.projetoCourse.entidades.Order;
import com.matthews.projetoCourse.services.OrderServices;

@RestController
@RequestMapping(value = "/order") // Caminho para buscar na web
public class OrderResource { // Apartir dessa classe que dar uma resposta para a web. Conseguindo mostrar na
								// tela.

	@Autowired
	private OrderServices orderServices;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() { // Usa esse metodo para retornar uma resposta para a pagina web.
		List<Order> listOrder = orderServices.findAll();
		return ResponseEntity.ok().body(listOrder);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order order = orderServices.findById(id);
		return ResponseEntity.ok().body(order);
	}
	
	@PostMapping
	public ResponseEntity<Order> insertOrder(@RequestBody Order order) {
		order = orderServices.insertOrder(order);
		return ResponseEntity.ok().body(order);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Order> atualizeOrder(@PathVariable Long id, @RequestBody Order order) {
		order = orderServices.atualizeOrder(id, order);
		return ResponseEntity.ok().body(order);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Order> deleteOrder(@PathVariable Long id) {
		orderServices.deleteOrder(id);
		return ResponseEntity.noContent().build();
	}
}