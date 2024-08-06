package com.example.E_commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_commerce.models.Product;
import com.example.E_commerce.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody Product product )
	{
		
		return productService.addProduct(product);	
	}
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAll()
	{
		return productService.getAll();
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteProduct(Long id)
	{
		return productService.deleteProduct(id);
	}
}
