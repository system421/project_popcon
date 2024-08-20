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
    
    void moveToKeep(int cartItemIdx, int fridgeIdx);
    void clearCartByCustomerIdx(int customerIdx);
    List<CartItemEntity> findCartItemsByCustomerIdx(int customerIdx);
    void deleteCartItemsByCustomerIdx(int customerIdx, List<Integer> excludeSkuIds);
    
    List<CartItemDTO> getCartItems(int cartIdx);
    void moveKeepItemToCart(int keepItemIdx, int cartIdx);
    
    }