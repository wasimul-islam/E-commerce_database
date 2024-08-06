package com.example.E_commerce.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.E_commerce.models.ResponseMessage;
import com.example.E_commerce.models.Customer;
import com.example.E_commerce.repositories.CustomerRepository;

@Service
public class CustomerServiceimpl implements CustomerService {
	
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public ResponseEntity<?> add(Customer customer) {
		if(Objects.isNull(customer.getName()) || customer.getName().trim().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Invalid name"));
		}
		return ResponseEntity.ok(customerRepository.save(customer));
	}

	@Override
	public ResponseEntity<?> getAll() {
		
		return ResponseEntity.ok(customerRepository.findAll());
	}

	@Override
	public ResponseEntity<?> update(Long id, Customer customer) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if(optionalCustomer.isPresent()) {
			optionalCustomer.get().setEmail(customer.getEmail().trim());
			customerRepository.save(optionalCustomer.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Not Found"));
		
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if(optionalCustomer.isPresent()) {
			customerRepository.deleteById(id);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Not Found"));
	}

}
