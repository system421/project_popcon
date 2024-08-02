package com.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dto.SkuDTO;
import com.store.mapper.SkuMapper;

@Service
public class SkuServiceImpl implements SkuService{

	SkuMapper skuMapper;

	  @Autowired
	  public SkuServiceImpl(SkuMapper skuMapper) {
	        this.skuMapper = skuMapper;
	    }
	  
	  @Override
	  public List<SkuDTO> findAll() {
	        return skuMapper.findAll();
	    }
	@Override
	public List<SkuDTO> findByType(int skutypeIdx) {
		return skuMapper.findByType(skutypeIdx);
	}
}
	

	

