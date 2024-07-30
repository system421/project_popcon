package com.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.entity.Customer;
import com.store.service.MemService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {

	
	@Autowired
    private MemService memService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerMem(@RequestBody Customer mem) {
    	
    	
    	log.info(mem.getCustomerId());
    	log.info(mem.getCustomerAdd());
    	System.out.println(mem);
        try {
            Customer registeredMember = memService.registerMem(mem);
            return ResponseEntity.ok(registeredMember);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
//    	return ResponseEntity.ok(null);
    }
    
}