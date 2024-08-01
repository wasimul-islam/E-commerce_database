package com.example.E_commerce.models;

import java.util.Date;

import com.example.E_commerce.enums.PaymentStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment extends Root{
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Cart cart;
	
	@Column
	private Date paymentDate;
	
	@Column
	private PaymentStatus paymentStatus;

	public Cart  getOrder() {
		return cart;
	}

	public void setOrder(Cart  cart) {
		this.cart = cart;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
}
