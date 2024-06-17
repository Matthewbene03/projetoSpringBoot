package com.matthews.projetoCourse.entidades.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private Integer code; //Para saber o codigo de cada enum e poder modificar do jeito que preferir. 
	
	private OrderStatus(Integer code){
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(Integer code) {
		for (OrderStatus os : OrderStatus.values()) {
			if(os.getCode() == code) {
				return os;
			}
		}
		throw new IllegalArgumentException("Error! Code invalied.");
	}
}
