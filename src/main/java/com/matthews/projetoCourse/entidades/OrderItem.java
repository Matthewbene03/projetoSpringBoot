package com.matthews.projetoCourse.entidades;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matthews.projetoCourse.entidades.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_OrderItem")
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderItemPK id;
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
		super();
	}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		id = new OrderItemPK();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	//@JsonIgnore
	public Order getOrderId() {
		return id.getOrder();
	}
	
	public void setOrderId(Order order) {
		this.id.setOrder(order);
	}
	
	@JsonIgnore
	public Product getProductId() {
		return id.getProduct();
	}
	
	public void setProductId(Product product) {
		this.id.setProduct(product);
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
}