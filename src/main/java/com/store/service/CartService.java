package com.store.service;

import java.util.List;

import com.store.dto.CartDTO;
import com.store.dto.CartItemDTO;
import com.store.entity.CartEntity;
import com.store.entity.CartItemEntity;

public interface CartService {
    CartDTO createCart(CartDTO cartDTO);
    CartItemDTO updateCartItemQuantity(int cartItemIdx, int skuValue);
    public void deleteCartItem(int cartItemIdx);
    List<CartDTO> getCartsByCustomerIdx(int customerIdx);
    CartItemEntity addToCart(CartItemDTO cartItemDTO);
    List<CartItemDTO> findAll();
    }