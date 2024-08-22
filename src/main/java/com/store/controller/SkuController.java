package com.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.CartDTO;
import com.store.dto.CartItemDTO;
import com.store.dto.SkuDTO;
import com.store.dto.WishDTO;
import com.store.dto.WishItemDTO;
import com.store.entity.CartEntity;
import com.store.entity.CartItemEntity;
import com.store.entity.Wish;
import com.store.entity.WishItemEntity;
import com.store.repository.SkuRepository;
import com.store.service.CartService;
import com.store.service.SkuService;
import com.store.service.WishService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class SkuController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	SkuService skuService;
	@Autowired
	CartService cartService;
	@Autowired
	WishService wishService;
	@Autowired
	private SkuRepository skuRepository;

	public SkuController(SkuService skuService) {
		this.skuService = skuService;
	}

	@GetMapping("/sku/{limit}")
	public List<SkuDTO> listSku(@PathVariable int limit) {
		List<SkuDTO> list = skuService.findAll(limit);
		System.out.println(skuService.findAll(limit));
		return list;
	}

	@GetMapping("/sku/type/{skutypeIdx}/{limit}")
	public List<SkuDTO> findByType(@PathVariable int skutypeIdx, @PathVariable int limit) {
		List<SkuDTO> list = skuService.findByType(skutypeIdx, limit);
		return skuService.findByType(skutypeIdx, limit);
	}

	@PostMapping("/sku/addToCart")
	public ResponseEntity<CartItemEntity> addToCart(@RequestBody CartItemDTO cartItemDTO) {
		CartItemEntity cartItemEntity = cartService.addToCart(cartItemDTO);
		return ResponseEntity.ok(cartItemEntity);
	}

	@PostMapping("/addToWish")
	public ResponseEntity<WishItemDTO> addToWish(@RequestBody WishItemDTO wishitemDto) {
		WishItemEntity wishItemEntity = wishService.addToWish(wishitemDto);
		return ResponseEntity.ok(WishItemDTO.of(wishItemEntity));
	}

}
