package com.store.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dto.CartDTO;
import com.store.dto.CustomerDTO;
import com.store.entity.Customer;
import com.store.mapper.CustomerMapper;
import com.store.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional 
public class MemServiceImpl implements MemService {

	 @Autowired
	    private CustomerRepository memRepository;

	 private final CustomerMapper customerMapper;

	    @Override
	    public CustomerDTO findById(int customerIdx) {
	        return customerMapper.findById(customerIdx);
	    }

	 
	    @Override
	    public Customer registerMem(Customer mem) {
	        if (memRepository.findBycustomerId(mem.getCustomerId()) != null) {
	            throw new IllegalArgumentException("User ID already exists");
	        }
	        if (memRepository.findBycustomerEmail(mem.getCustomerEmail()) != null) {
	            throw new IllegalArgumentException("Email already exists");
	        }
	        return memRepository.save(mem);
	    }

	 
	}
