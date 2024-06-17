package com.matthews.projetoCourse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matthews.projetoCourse.entidades.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
