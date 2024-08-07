package com.store.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.store.dto.CustomerDTO;
import com.store.entity.Customer;
import com.store.repository.CustomerRepository;

@Service
public interface MemService {
	 Customer registerMem(Customer mem);
	 CustomerDTO findById(@Param("customerIdx") int customerIdx);

    }

