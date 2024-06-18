package com.matthews.projetoCourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthews.projetoCourse.Repository.CategoryRepository;
import com.matthews.projetoCourse.entidades.Category;
import com.matthews.projetoCourse.entidades.Category;

@Service
public class CategoryServices {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		List<Category> listCategory = categoryRepository.findAll();
		return listCategory;
	}
	
	public Category findById(Long id){
		Optional<Category> category = categoryRepository.findById(id);
		return category.get();
	}
	
	public Category insertCategory(Category category) {
		return null;
	}
	
	public Category atualizeCategory() {
		return null;
	}
	
	public void deleteCategory() {
		
	}
}
