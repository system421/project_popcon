package com.store.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;

import com.store.dto.CartDTO;
import com.store.dto.SkuDTO;
import com.store.dto.WishDTO;
import com.store.entity.Cart;
import com.store.entity.Wish;

public interface WishService {
	List<WishDTO> findAll();
	Wish addToWish(WishDTO wish);
    void deleteFromWish(int wishIdx);
}
