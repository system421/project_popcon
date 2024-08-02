package com.store.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.store.dto.SkuDTO;

public interface SkuService {
	List<SkuDTO> findAll();
	List<SkuDTO> findByType(@Param("skutypeIdx") int skutypeIdx);
}
