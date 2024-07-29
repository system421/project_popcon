package com.exam.controller;


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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.Sku;
import com.exam.service.MemberService;
import com.exam.service.SkuService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class SkuController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	SkuService skuService;
    public SkuController(SkuService skuService) {
        this.skuService = skuService;
    }
	@GetMapping("/Sku")
    public List<Sku> listSku() {
		List<Sku> list = skuService.findAll();
		System.out.println(skuService.findAll());
        return list;
        
    } 
	@GetMapping("/Sku/type/{skutypeIdx}")
	public List<Sku> findByType(@PathVariable int skutypeIdx) {
		List<Sku> list = skuService.findByType(skutypeIdx);
		return skuService.findByType(skutypeIdx);
	    }

}













