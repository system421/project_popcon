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
import com.store.entity.CartEntity;
import com.store.entity.CartItemEntity;
import com.store.entity.Wish;
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
	
    public SkuController(SkuService skuService) {
        this.skuService = skuService;
    }
	@GetMapping("/Sku")
    public List<SkuDTO> listSku() {
		List<SkuDTO> list = skuService.findAll();
		System.out.println(skuService.findAll());
        return list;
        
    } 
	@GetMapping("/Sku/type/{skutypeIdx}")
	public List<SkuDTO> findByType(@PathVariable int skutypeIdx) {
		List<SkuDTO> list = skuService.findByType(skutypeIdx);
		return skuService.findByType(skutypeIdx);
	    }
	  @PostMapping("/Sku/addToCart")
	    public ResponseEntity<CartItemEntity> addToCart(@RequestBody CartItemDTO cartItemDTO) {
	        CartItemEntity cartItemEntity = cartService.addToCart(cartItemDTO);
	        return ResponseEntity.ok(cartItemEntity);
	    }

    @PostMapping("/Sku/addToWish")
    public Wish addToWish(@RequestBody WishDTO wishDto) {
        return wishService.addToWish(wishDto);
    }
}
