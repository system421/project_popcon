package com.store.service;

import java.util.List;

import com.store.dto.CartDTO;
import com.store.entity.CartEntity;

public interface CartService {
	  CartDTO getCartByCustomerId(int customerIdx);
	    CartDTO createCart(CartDTO cartDTO);
	    CartDTO updateCart(CartDTO cartDTO);
	    void deleteCart(int cartIdx);
}