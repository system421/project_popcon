package com.store.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;



import com.store.dto.SkuDTO;

public interface SkuService {
	List<SkuDTO> findAll(int limit);
	List<SkuDTO> findByType(int skutypeIdx, int limit);
}
