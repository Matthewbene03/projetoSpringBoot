package com.matthews.projetoCourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.matthews.projetoCourse.Repository.OrderRepository;
import com.matthews.projetoCourse.entidades.Order;
import com.matthews.projetoCourse.services.exception.DatabaseException;
import com.matthews.projetoCourse.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderServices {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findAll() {
		List<Order> listOrder = orderRepository.findAll();
		return listOrder;
	}
	
	public Order findById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		return order.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Order insertOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public Order atualizeOrder(Long id, Order order) {
		try {
			Order auxOrder = orderRepository.getReferenceById(id);
			atualize(auxOrder, order);
			return orderRepository.save(auxOrder);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void atualize(Order auxOrder, Order order) {
		auxOrder.setOrderStatus(order.getOrderStatus());
	}

	public void deleteOrder(Long id) {
		try {
			orderRepository.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
