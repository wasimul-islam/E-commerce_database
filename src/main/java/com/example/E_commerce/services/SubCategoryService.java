package com.example.E_commerce.services;

import org.springframework.http.ResponseEntity;

import com.example.E_commerce.models.SubCategory;

public interface SubCategoryService {
	ResponseEntity<?> addSubCategory(SubCategory subCategory);
	ResponseEntity<?> getAll();
	ResponseEntity<?> deleteSubCategory(Long id);
}
