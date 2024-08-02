package com.store.controller;


import java.util.List;

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
import com.store.entity.Cart;
import com.store.entity.Wish;
import com.store.service.CartService;
import com.store.service.SkuService;
import com.store.service.WishService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class WishController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	WishService wishService;
    public WishController(WishService wishService) {
        this.wishService = wishService;
    }
    @GetMapping("/Wish")
    public ResponseEntity<List<WishDTO>> findAll() {
        List<WishDTO> allWishes = wishService.findAll();
        return ResponseEntity.ok(allWishes);
        
    }
	@PostMapping("/Wish/add")
    public ResponseEntity<Wish> addToWish(@RequestBody WishDTO wishDto) {
        Wish newWishItem = wishService.addToWish(wishDto);
        return ResponseEntity.ok(newWishItem);
    }

  
    @DeleteMapping("/Wish/delete/{wishIdx}")
    public ResponseEntity<Void> deleteFromWish(@PathVariable int wishIdx) {
        wishService.deleteFromWish(wishIdx);
        return ResponseEntity.noContent().build();
    }
}













