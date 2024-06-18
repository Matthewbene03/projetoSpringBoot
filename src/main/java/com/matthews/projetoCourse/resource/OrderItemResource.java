package com.matthews.projetoCourse.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matthews.projetoCourse.entidades.OrderItem;
import com.matthews.projetoCourse.services.OrderItemServices;

@RestController
@RequestMapping(value = "/OrderItem") //Caminho para buscar na web
public class OrderItemResource { //Apartir dessa classe que dar uma resposta para a web. Conseguindo mostrar na tela. 
	
	@Autowired
	private OrderItemServices orderItemServices;
	
	@GetMapping
	public ResponseEntity<List<OrderItem>> findAll(){ //Usa esse metodo para retornar uma resposta para a pagina web.
		List<OrderItem> listOrderItem = orderItemServices.findAll();
		return ResponseEntity.ok().body(listOrderItem);
	}
	
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<OrderItem> findById(@PathVariable Long id) {
//		OrderItem OrderItem = orderItemServices.findById(id);
//		return ResponseEntity.ok().body(OrderItem);
//	}
}
