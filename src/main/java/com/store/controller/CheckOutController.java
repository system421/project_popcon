package com.store.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.CartDTO;
import com.store.dto.CheckOutDTO;
import com.store.dto.SkuDTO;
import com.store.service.CartService;
import com.store.service.CheckOutService;
import com.store.service.SkuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class CheckOutController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private  CheckOutService checkOutService;
	
	    @Autowired
	    public CheckOutController(CheckOutService checkOutService) {
	        this.checkOutService = checkOutService;
	    }
	
		//유저 정보 불러오기
	    @GetMapping("/findCustomer")
	    public List<CheckOutDTO> findCustomer(Integer userid) {
	    	userid = 10; //유저의 값지정 (수정필요)
	        return checkOutService.findCustomer(userid);
	    }
	    
	    //장바구니 불러오기
	    @GetMapping("/findCart")
	    public List<CheckOutDTO> findCart(Integer userid) {
	    	userid = 10; // 유저의 값지정 (수정필요)
	    	List<CheckOutDTO>xx=checkOutService.findCart(userid);
	    	System.out.println(xx);
	        return xx;
	    }
//
//	    @PostMapping("/PayOrder/add")
//	    public PayOrder addPayOrder(@RequestBody PayOrder payOrder) {
//	        return payOrderService.save(payOrder);
//	    }
//
//	    @PutMapping("/PayOrder/update")
//	    public PayOrder updatePayOrder(@RequestBody PayOrder payOrder) {
//	        return payOrderService.save(payOrder);
//	    }
//
//	    @DeleteMapping("/PayOrder/delete/{id}")
//	    public void deletePayOrder(@PathVariable int id) {
//	        payOrderService.deleteById(id);
//	    }
	 

}













