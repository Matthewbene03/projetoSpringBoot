package com.matthews.projetoCourse.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long idPayment;
	private Date moment;
	
	private Order orderPayment;

	public Payment() {
		super();
	}

	public Payment(Long idPayment, Date moment, Order orderPayment) {
		this.idPayment = idPayment;
		this.moment = moment;
		this.orderPayment = orderPayment;
	}

	public Long getIdPayment() {
		return idPayment;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
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
