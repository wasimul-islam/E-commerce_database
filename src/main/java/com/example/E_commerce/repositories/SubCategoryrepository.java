package com.example.E_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.E_commerce.models.SubCategory;

@Repository
public interface SubCategoryrepository extends JpaRepository<SubCategory, Long> {

}
