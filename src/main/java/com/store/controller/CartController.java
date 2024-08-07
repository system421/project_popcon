package com.store.controller;


import com.store.dto.CartDTO;
import com.store.entity.CartEntity;
import com.store.service.CartService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {

	 @Autowired
	    private CartService cartService;

	    @GetMapping("/{customerIdx}")
	    public ResponseEntity<CartDTO> getCartByCustomerId(@PathVariable int customerIdx) {
	        CartDTO cartDTO = cartService.getCartByCustomerId(customerIdx);
	        return ResponseEntity.ok(cartDTO);
	    }

	    @PostMapping
	    public ResponseEntity<CartDTO> createCart(@RequestBody CartDTO cartDTO) {
	        CartDTO createdCart = cartService.createCart(cartDTO);
	        return ResponseEntity.ok(createdCart);
	    }

	    @PutMapping("/{cartIdx}")
	    public ResponseEntity<CartDTO> updateCart(@PathVariable int cartIdx, @RequestBody CartDTO cartDTO) {
	        cartDTO.setCartIdx(cartIdx);
	        CartDTO updatedCart = cartService.updateCart(cartDTO);
	        return ResponseEntity.ok(updatedCart);
	    }

	    @DeleteMapping("/{cartIdx}")
	    public ResponseEntity<Void> deleteCart(@PathVariable int cartIdx) {
	        cartService.deleteCart(cartIdx);
	        return ResponseEntity.noContent().build();
	    }
}