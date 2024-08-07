package com.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.entity.CartEntity;
import com.store.entity.Customer;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer> {

}
