package com.matthews.projetoCourse.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matthews.projetoCourse.entidades.Category;
import com.matthews.projetoCourse.services.CategoryServices;

@RestController
@RequestMapping(value = "/category") //Caminho para buscar na web
public class CategoryResource { //Apartir dessa classe que dar uma resposta para a web. Conseguindo mostrar na tela. 
	
	@Autowired
	private CategoryServices categoryServices;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){ //Usa esse metodo para retornar uma resposta para a pagina web.
		List<Category> listCategory = categoryServices.findAll();
		return ResponseEntity.ok().body(listCategory);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category category = categoryServices.findById(id);
		return ResponseEntity.ok().body(category);
	}
}
