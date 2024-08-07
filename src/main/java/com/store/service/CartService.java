package com.store.service;

import java.util.List;

import com.store.dto.CartDTO;
import com.store.dto.CartItemDTO;
import com.store.entity.CartEntity;
import com.store.entity.CartItemEntity;

public interface CartService {
    CartDTO createCart(CartDTO cartDTO);
    CartDTO updateCart(int cartIdx, CartDTO cartDTO);
    void deleteCart(int cartIdx);
    List<CartDTO> getCartsByCustomerIdx(int customerIdx);
    CartItemEntity addToCart(CartItemDTO cartItemDTO);
    }