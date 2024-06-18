package com.matthews.projetoCourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthews.projetoCourse.Repository.OrderItemRepository;
import com.matthews.projetoCourse.entidades.Order;
import com.matthews.projetoCourse.entidades.OrderItem;

@Service
public class OrderItemServices {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public List<OrderItem> findAll() {
		List<OrderItem> listOrderItem = orderItemRepository.findAll();
		return listOrderItem;
	}
	
//	public OrderItem findById(Long id){
//		Optional<OrderItem> OrderItem = orderItemRepository.findById(id);
//		return OrderItem.get();
//	}
	
	public OrderItem insertOrderItem(OrderItem orderItem) {
		return null;
	}
	
	public OrderItem atualizeOrderItem(OrderItem orderItem) {
		return null;
	}
	
	public void deleteOrderItem() {
		
	}
}
