package com.example.E_commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.E_commerce.models.Category;
import com.example.E_commerce.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addCategory(@RequestBody Category category )
	{
		
		return categoryService.addCategory(category);	
	}
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAll()
	{
		return categoryService.getAll();
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteCategory(Long id)
	{
		return categoryService.deleteCategory(id);
	}
}
