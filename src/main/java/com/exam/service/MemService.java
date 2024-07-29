package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.exam.entity.Customer;
import com.exam.repository.CustomerRepository;

@Service
public interface MemService {
	 Customer registerMem(Customer mem);
    }

