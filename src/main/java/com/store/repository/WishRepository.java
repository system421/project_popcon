package com.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.entity.CartEntity;
import com.store.entity.Customer;
import com.store.entity.Wish;

@Repository
public interface WishRepository extends JpaRepository<Wish, Integer> {
	
}
