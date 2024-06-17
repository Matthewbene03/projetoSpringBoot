package com.matthews.projetoCourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthews.projetoCourse.Repository.OrderRepository;
import com.matthews.projetoCourse.entidades.Order;

@Service
public class OrderServices {

	@Autowired
	private OrderRepository orderRepository;

	public Order findById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		return order.get();
	}

	public List<Order> findAll() {
		List<Order> listOrder = orderRepository.findAll();
		return listOrder;
	}
}
