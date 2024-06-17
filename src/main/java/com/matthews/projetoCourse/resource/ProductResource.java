package com.matthews.projetoCourse.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matthews.projetoCourse.entidades.Product;
import com.matthews.projetoCourse.services.ProductServices;

@RestController
@RequestMapping(value = "/product") //Caminho para buscar na web
public class ProductResource { //Apartir dessa classe que dar uma resposta para a web. Conseguindo mostrar na tela. 
	
	@Autowired
	private ProductServices productServices;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){ //Usa esse metodo para retornar uma resposta para a pagina web.
		List<Product> listProduct = productServices.findAll();
		return ResponseEntity.ok().body(listProduct);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product Product = productServices.findById(id);
		return ResponseEntity.ok().body(Product);
	}
}
