package com.matthews.projetoCourse.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.matthews.projetoCourse.enums.OrderStatus;

public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long idOrder;
	private Date moment;
	private OrderStatus orderStatus;
	
	private User userOrder;
	private Payment payment;
	private Product productOrder;
	
	public Order() {}
	
	public Order(Long idOrder, Date moment, OrderStatus orderStatus, User userOrder, Payment payment, Product productOrder) {
		super();
		this.idOrder = idOrder;
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.userOrder = userOrder;
		this.payment = payment;
		this.productOrder = productOrder;
	}
	public Long getIdOrder() {
		return idOrder;
	}
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public User getUserOrder() {
		return userOrder;
	}
	public void setUserOrder(User userOrder) {
		this.userOrder = userOrder;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	
	public Product getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(Product productOrder) {
		this.productOrder = productOrder;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idOrder);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(idOrder, other.idOrder);
	}
}
