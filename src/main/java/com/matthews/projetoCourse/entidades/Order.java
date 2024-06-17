package com.matthews.projetoCourse.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.matthews.projetoCourse.entidades.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrder;
	private Instant moment;
	
	private Integer orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "IdUser")
	private User userOrder;
	
	public Order() {}
	
	public Order(Long idOrder, Instant moment, OrderStatus orderStatus, User userOrder) {
		this.idOrder = idOrder;
		this.moment = moment;
		this.setOrderStatus(orderStatus);
		this.userOrder = userOrder;
	}
	public Long getIdOrder() {
		return idOrder;
	}
	public Instant getMoment() {
		return moment;
	}
	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	public User getUserOrder() {
		return userOrder;
	}
	public void setUserOrder(User userOrder) {
		this.userOrder = userOrder;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus.getCode();
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
