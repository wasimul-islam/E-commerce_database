package com.example.E_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.E_commerce.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
