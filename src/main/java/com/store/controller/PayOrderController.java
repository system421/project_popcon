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
import com.store.dto.PayOrderDTO;
import com.store.dto.SkuDTO;
import com.store.entity.Cart;
import com.store.entity.PayOrder;
import com.store.service.CartService;
import com.store.service.PayOrderService;
import com.store.service.SkuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class PayOrderController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	  private final PayOrderService payOrderService;

	    @Autowired
	    public PayOrderController(PayOrderService payOrderService) {
	        this.payOrderService = payOrderService;
	    }

	    @GetMapping("/PayOrder")
	    public List<PayOrderDTO> listPayOrders() {
	        return payOrderService.findAll();
	    }

	    @PostMapping("/PayOrder/add")
	    public PayOrder addPayOrder(@RequestBody PayOrder payOrder) {
	        return payOrderService.save(payOrder);
	    }

	    @PutMapping("/PayOrder/update")
	    public PayOrder updatePayOrder(@RequestBody PayOrder payOrder) {
	        return payOrderService.save(payOrder);
	    }

	    @DeleteMapping("/PayOrder/delete/{id}")
	    public void deletePayOrder(@PathVariable int id) {
	        payOrderService.deleteById(id);
	    }
	 

}













