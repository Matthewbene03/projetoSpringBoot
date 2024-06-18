package com.matthews.projetoCourse.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.matthews.projetoCourse.Repository.ProductRepository;
import com.matthews.projetoCourse.entidades.Product;
import com.matthews.projetoCourse.services.exception.DatabaseException;
import com.matthews.projetoCourse.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		List<Product> listProduct = productRepository.findAll();
		return listProduct;
	}
	
	public Product findById(Long id){
		try {
			Optional<Product> product = productRepository.findById(id);
			return product.get();
		} catch(NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Product insertProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product atualizeProduct(Long id, Product product) {
		try {
			Product auxProduct = productRepository.getReferenceById(id);
			atualize(auxProduct, product);
			return productRepository.save(auxProduct);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void atualize(Product auxProduct, Product product) {
		auxProduct.setNameProduct(product.getNameProduct());
		auxProduct.setPriceProduct(product.getPriceProduct());
		auxProduct.setImgUrl(product.getImgUrl());
		auxProduct.setDescriptionProduct(product.getDescriptionProduct());
	}
	
	public void deleteProduct(Long id) {
		try {
			productRepository.deleteById(id);
		}catch(DataIntegrityViolationException e){
			throw new DatabaseException(e.getMessage());
		}
	}
}
