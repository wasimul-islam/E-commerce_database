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
	@GetMapping("/get-price/{id}")
	public ResponseEntity<?> getPrice(@PathVariable Long id)
	{
		return productService.getPrice(id);
	}
	@GetMapping("/get-stock/{id}")
	public ResponseEntity<?> getStock(@PathVariable Long id)
	{
		return productService.getStock(id);
	}
	@GetMapping("/get-discount/{id}")
	public ResponseEntity<?> getDiscount(@PathVariable Long id)
	{
		return productService.getDiscount(id);
	}
	@GetMapping("/get-attributes/{id}")
	public ResponseEntity<?> getAttributes(@PathVariable Long id)
	{
		return productService.getAttributes(id);
	}
	
	@PutMapping("/update-name/{id}")
	public ResponseEntity<?> updateName(@PathVariable Long id, String name)
	{
		return productService.updateName(id,name);
	}
	@PutMapping("/update-price/{id}")
	public ResponseEntity<?> updateName(@PathVariable Long id, int price)
	{
		return productService.updatePrice(id,price);
	}
	@PutMapping("/update-discount/{id}")
	public ResponseEntity<?> updateDiscount(@PathVariable Long id, int discount)
	{
		return productService.updateDiscount(id,discount);
	}
	@PutMapping("/update-stock/{id}")
	public ResponseEntity<?> updateStock(@PathVariable Long id, int stock)
	{
		return productService.updateStock(id,stock);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteProduct(Long id)
	{
		return productService.deleteProduct(id);
	}
}
