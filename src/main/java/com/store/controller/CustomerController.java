package com.store.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.CustomerDTO;
import com.store.entity.Customer;
import com.store.service.MemService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@AllArgsConstructor
public class CustomerController {

	
	private final MemService memService;

	
	@GetMapping("/Customer/{customerIdx}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int customerIdx) {
        CustomerDTO customerDTO = memService.findById(customerIdx);
        return ResponseEntity.ok(customerDTO);
    }
	
    @PostMapping("/signup")
    public ResponseEntity<?> registerMem(@RequestBody Customer mem) {
    	
    	LocalDateTime time = LocalDateTime.now();
    	Timestamp t = Timestamp.valueOf(time);
    	log.info(mem.getCustomerId());
    	log.info(mem.getCustomerAdd());
    	mem.setCustomerGender(1);
    	mem.setCustomerTime(t);
    	String ecrptPW = new BCryptPasswordEncoder().encode(mem.getCustomerPw());
		mem.setCustomerPw(ecrptPW);
    	System.out.println(mem);
        try {
            Customer registeredMember = memService.registerMem(mem);
            return ResponseEntity.ok(registeredMember);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
//    	return ResponseEntity.ok(null);
    }
    @GetMapping("/check-id")
    public ResponseEntity<Map<String, Boolean>> checkId(@RequestParam String userid) {
      boolean isUnique = true;
      Customer dto = memService.findByUserID(userid);
      if(dto != null) {
    	  isUnique = false;
      }
      log.info("아이디확인");
      log.info(userid);
      Map<String, Boolean> response = new HashMap<>();
      response.put("isUnique", isUnique);
      return ResponseEntity.ok(response);
    }
    
}