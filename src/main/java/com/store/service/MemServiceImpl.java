package com.store.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.entity.Customer;
import com.store.repository.CustomerRepository;

@Service
@Transactional 
public class MemServiceImpl implements MemService {

	 @Autowired
	    private CustomerRepository memRepository;

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
