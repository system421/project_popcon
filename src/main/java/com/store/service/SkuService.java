package com.store.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;

import com.store.dto.Member;
import com.store.dto.Sku;

public interface SkuService {
	List<Sku> findAll();
	List<Sku> findByType(@Param("skutypeIdx") int skutypeIdx);
}
