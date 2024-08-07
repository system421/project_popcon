package com.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>  {

	
	
	 Customer findBycustomerId(String customerId);
	 Customer findById(String customerId);
	 Customer findBycustomerEmail(String customerEmail);
}
