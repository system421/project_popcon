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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.KeepDTO;
import com.store.dto.SkuDTO;
import com.store.service.KeepService;
import com.store.service.SkuService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class KeepController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	KeepService keepService;
    public KeepController(SkuService skuService) {
        this.keepService = keepService;
    }
	@GetMapping("/Keep")
    public List<KeepDTO> listKeep() {
        return keepService.findAll();
        
    } 

}













