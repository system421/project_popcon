package com.store.service;

import java.util.Map;

import com.store.dto.CustomerDTO;
import com.store.entity.Customer;

public interface AuthenticationService {

	
	  public CustomerDTO authenticate(Map<String, String> map);
	  
	  public CustomerDTO findById(String userid);
	  
}
