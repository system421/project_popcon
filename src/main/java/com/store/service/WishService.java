package com.store.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;

import com.store.dto.CartDTO;
import com.store.dto.SkuDTO;
import com.store.dto.WishDTO;
import com.store.dto.WishItemDTO;
import com.store.entity.CartEntity;
import com.store.entity.Wish;
import com.store.entity.WishItemEntity;

public interface WishService {
	WishDTO createWish(WishDTO wishDTO);
	WishItemDTO updateWishItemQuantity(int wishItemIdx);
	public void deleteWishItem(int wishItemIdx);
	List<WishDTO> getWishesByCustomerIdx(int customerIdx);
	WishItemEntity addToWish(WishItemDTO wishItemDTO);
	List<WishItemDTO> findAll();
}
