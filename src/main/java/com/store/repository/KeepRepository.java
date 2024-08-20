package com.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Customer;
import com.store.entity.Keep;

public interface KeepRepository extends JpaRepository<Keep, Integer>  {

	Keep findByCustomerCustomerIdx(int customerIdx);
}
