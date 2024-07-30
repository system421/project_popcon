package com.store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.store.dto.Member;
import com.store.dto.Sku;
import com.store.mapper.SkuMapper;

@Service
public class SkuServiceImpl implements SkuService{

	SkuMapper skuMapper;

	  @Autowired
	  public SkuServiceImpl(SkuMapper skuMapper) {
	        this.skuMapper = skuMapper;
	    }
	  
	  @Override
	  public List<Sku> findAll() {
	        return skuMapper.findAll();
	    }
	@Override
	public List<Sku> findByType(int skutypeIdx) {
		return skuMapper.findByType(skutypeIdx);
	}
}
	

	

