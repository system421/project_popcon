package com.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.entity.Cart;
import com.store.entity.Customer;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
}
