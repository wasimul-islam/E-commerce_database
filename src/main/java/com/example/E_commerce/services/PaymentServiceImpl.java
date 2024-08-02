package com.example.E_commerce.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.E_commerce.models.Payment;
import com.example.E_commerce.models.ResponseMessage;
import com.example.E_commerce.repositories.paymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private paymentRepository paymentRepository;

	@Override
	public ResponseEntity<?> addPayment(Payment payment) {
		if(Objects.isNull(payment))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid payment"));

		}
		else {
			paymentRepository.save(payment);      
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Payment added"));
	}

	@Override
	public ResponseEntity<?> getAll() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(paymentRepository.findAll());
	}

	@Override
	public ResponseEntity<?> deletePayment(Long id) {
		if(Objects.isNull(paymentRepository.findById(id)))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Not found"));

		}
		else {
			paymentRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseMessage("Payment deleted"));
	}
	
	
}
