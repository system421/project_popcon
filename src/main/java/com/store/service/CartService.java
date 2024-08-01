package com.store.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;

import com.store.dto.CartDTO;
import com.store.dto.MemberDTO;
import com.store.dto.SkuDTO;
import com.store.entity.Cart;

public interface CartService {
	List<CartDTO> findAll();
	Cart addToCart(CartDTO cart);
    Cart updateCart(CartDTO cart);
    void deleteFromCart(int cartIdx);
}
