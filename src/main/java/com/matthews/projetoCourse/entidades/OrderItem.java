package com.matthews.projetoCourse.entidades;

import java.io.Serializable;
import java.util.Objects;

public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
		super();
	}

	public OrderItem(Integer quantity, Double price) {
		super();
		this.quantity = quantity;
		this.price = price;
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
		return Objects.hash(price, quantity);
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
		return Objects.equals(price, other.price) && Objects.equals(quantity, other.quantity);
	}
}
