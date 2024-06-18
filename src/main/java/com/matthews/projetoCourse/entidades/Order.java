package com.matthews.projetoCourse.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matthews.projetoCourse.entidades.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	private Double total;
	
	private Integer orderStatus;
	
	@OneToOne(mappedBy = "orderPayment", cascade = CascadeType.ALL)
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name = "IdUser")
	private User userOrder;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> setOrderItem = new HashSet<>();
	
	public Order() {}
	
	public Order(Long idOrder, Instant moment, OrderStatus orderStatus, User userOrder) {
		this.id = idOrder;
		this.moment = moment;
		this.setOrderStatus(orderStatus);
		this.userOrder = userOrder;
		this.total = getTotal();
	}
	
	public Double getTotal() {
		Double soma = 0.0;
		for(OrderItem x: setOrderItem) {
			soma += x.getSubTotal();
		}
		return soma;
	}
	
	public Long getIdOrder() {
		return id;
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
	
	public Set<OrderItem> getSetOrderItem() {
		return setOrderItem;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
}
