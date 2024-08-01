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
import com.store.dto.SkuDTO;
import com.store.entity.Cart;
import com.store.service.CartService;
import com.store.service.MemberService;
import com.store.service.SkuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class CartController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	  @Autowired
	CartService cartService;
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    
    @GetMapping("/Cart")
    public List<CartDTO> listCart() {
        return cartService.findAll();
    }
   
	
	@PostMapping("/Cart/add")
    public ResponseEntity<Cart> addToCart(@RequestBody CartDTO cartDto) {
        Cart newCartItem = cartService.addToCart(cartDto);
        return ResponseEntity.ok(newCartItem);
    }

    @PutMapping("/Cart/update")
    public ResponseEntity<Cart> updateCart(@RequestBody CartDTO cartDto) {
        Cart updatedCartItem = cartService.updateCart(cartDto);
        return ResponseEntity.ok(updatedCartItem);
    }

    @DeleteMapping("/Cart/delete/{cartIdx}")
    public ResponseEntity<Void> deleteFromCart(@PathVariable int cartIdx) {
        cartService.deleteFromCart(cartIdx);
        return ResponseEntity.noContent().build();
    }



}













