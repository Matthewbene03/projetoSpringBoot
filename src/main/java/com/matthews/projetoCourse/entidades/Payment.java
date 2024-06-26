package com.matthews.projetoCourse.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPayment;
	private Instant moment;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Order orderPayment;

	public Payment() {
		super();
	}

	public Payment(Long idPayment, Instant moment, Order orderPayment) {
		this.idPayment = idPayment;
		this.moment = moment;
		this.orderPayment = orderPayment;
	}

	public Long getIdPayment() {
		return idPayment;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Order getOrderPayment() {
		return orderPayment;
	}

	public void setOrderPayment(Order orderPayment) {
		this.orderPayment = orderPayment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPayment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(idPayment, other.idPayment);
	}
}
