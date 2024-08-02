package com.example.E_commerce.services;

import org.springframework.http.ResponseEntity;

import com.example.E_commerce.models.Category;

public interface CategoryService {
	ResponseEntity<?> addCategory(Category category);
	ResponseEntity<?> getAll();
	ResponseEntity<?> deleteCategory(Long id);
}
