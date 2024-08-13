package com.store.controller;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.CartDTO;
import com.store.dto.SkuDTO;
import com.store.dto.WishDTO;
import com.store.dto.WishItemDTO;
import com.store.entity.CartEntity;
import com.store.entity.Wish;
import com.store.entity.WishItemEntity;
import com.store.service.CartService;
import com.store.service.SkuService;
import com.store.service.WishService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class WishController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	
	private final WishService wishService;
    public WishController(WishService wishService) {
        this.wishService = wishService;
    }
    @GetMapping("/Wish/items")
    public ResponseEntity<List<WishItemDTO>> findAll() {
        return ResponseEntity.ok(wishService.findAll());        
    }
    @GetMapping("/Wish/{customerIdx}")
    public ResponseEntity<List<WishDTO>>getWishesByCustomerIdx(@PathVariable int customerIdx){
    	return ResponseEntity.ok(wishService.getWishesByCustomerIdx(customerIdx));
    }
	@PostMapping("/Wish/add")
    public ResponseEntity<WishItemDTO> addToWish(@RequestBody WishItemDTO wishItemDto) {
        WishItemEntity wishItemEntity = wishService.addToWish(wishItemDto);
        return ResponseEntity.ok(WishItemDTO.of(wishItemEntity));
    }
	@PostMapping("/create")
	public ResponseEntity<WishDTO> createWish(@RequestBody WishDTO wishDTO){
		return ResponseEntity.ok(wishService.createWish(wishDTO));
	}
    @DeleteMapping("/Wish/delete/{wishItemIdx}")
    public ResponseEntity<Void> deleteWishItem(@PathVariable int wishItemIdx) {
        wishService.deleteWishItem(wishItemIdx);

        return ResponseEntity.noContent().build();
    }
   
}
