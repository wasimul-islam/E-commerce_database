package com.example.E_commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_commerce.models.Customer;
import com.example.E_commerce.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer )
	{
		
		return customerService.add(customer);	
	}
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAll()
	{
		return customerService.getAll();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, Customer customer)
	{
		return customerService.update(id, customer);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(Long id)
	{
		return customerService.delete(id);
	}
	
}