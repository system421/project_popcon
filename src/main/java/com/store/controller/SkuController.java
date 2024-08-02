package com.store.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.SkuDTO;
import com.store.entity.Sku;
import com.store.service.SkuService;

@RestController
public class SkuController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	SkuService skuService;
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

}













