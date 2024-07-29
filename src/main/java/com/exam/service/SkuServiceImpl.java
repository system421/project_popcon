package com.exam.service;

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
import com.exam.dto.Member;
import com.exam.dto.Sku;
import com.exam.mapper.MemberMapper;
import com.exam.mapper.SkuMapper;
import com.exam.service.MemberService;
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
	

	

