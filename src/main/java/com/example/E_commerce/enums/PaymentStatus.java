package com.example.E_commerce.enums;

public enum PaymentStatus {
	
	PAID("PAID"),UNPAID("UNPAID");

	private String value;

	public String getValue() {
		return value;
	}

	private PaymentStatus(String value) {
		// TODO Auto-generated constructor stub
	
		this.value = value;
	}
	
}
