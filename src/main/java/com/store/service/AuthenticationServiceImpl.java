package com.store.service;

import java.util.Map;
import org.springframework.stereotype.Service;

import com.store.dto.CustomerDTO;
import com.store.entity.Customer;
import com.store.mapper.CustomerMapper;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	CustomerMapper customerMapper;
	
	public AuthenticationServiceImpl(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}


	@Override
	public CustomerDTO authenticate(Map<String, String> map) {
		return customerMapper.authenticate(map);
	}


	@Override
	public CustomerDTO findById(String id) {
		return customerMapper.findByUserId(id);
	}

}
