package com.example.E_commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_commerce.models.Payment;
import com.example.E_commerce.services.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	
	@Autowired
	private PaymentService paymentService; 
	
	@PostMapping("/add")
	public ResponseEntity<?> addPayment(@RequestBody Payment payment)
	{
		
		return paymentService.addPayment(payment);	
	}
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAll()
	{
		return paymentService.getAll();
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deletePayment(Long id)
	{
		return paymentService.deletePayment(id);
	}
}
