package com.matthews.projetoCourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthews.projetoCourse.Repository.ProductRepository;
import com.matthews.projetoCourse.entidades.Product;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		List<Product> listProduct = productRepository.findAll();
		return listProduct;
	}
	
	public Product findById(Long id){
		Optional<Product> product = productRepository.findById(id);
		return product.get();
	}
}
