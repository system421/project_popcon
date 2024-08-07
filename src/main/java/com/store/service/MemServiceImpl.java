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

	  private final CustomerRepository customerRepository;

	  @Override
	  public CustomerDTO findById(int customerId) {
	        Customer customer = customerRepository.findByCustomerIdx(customerId);
	        return new CustomerDTO(customer);
	    }
	 
	    @Override
	    public Customer registerMem(Customer mem) {
//	        if (memRepository.findBycustomerId(mem.getCustomerId()) != null) {
//	            throw new IllegalArgumentException("User ID already exists");
//	        }
//	        if (memRepository.findBycustomerEmail(mem.getCustomerEmail()) != null) {
//	            throw new IllegalArgumentException("Email already exists");
//	        }
	        return customerRepository.save(mem);
	    }
		@Override
		public Customer findByUserID(String id) {
			
			return memRepository.findBycustomerId(id);
		}

	 
	}
