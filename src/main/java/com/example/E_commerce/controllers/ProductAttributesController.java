package com.example.E_commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_commerce.models.ProductAttributes;
import com.example.E_commerce.services.ProductAttributeService;

@RestController
@RequestMapping("/product-attributes")
public class ProductAttributesController {

	 @Autowired
	 private ProductAttributeService productAttributeService;
	 
	 @PostMapping("/add")
		public ResponseEntity<?> addProductAttribute(@RequestBody ProductAttributes productAttribute)
		{
			
			return productAttributeService.addProductAttribute(productAttribute);	
		}
		
		@GetMapping("/get-all")
		public ResponseEntity<?> getAll()
		{
			return productAttributeService.getAll();
		}
		
		@DeleteMapping("/delete")
		public ResponseEntity<?> deleteProductAttribute(Long id)
		{
			return productAttributeService.deleteProductAttribute(id);
		}
}
