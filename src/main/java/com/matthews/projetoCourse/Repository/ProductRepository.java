package com.matthews.projetoCourse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matthews.projetoCourse.entidades.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
