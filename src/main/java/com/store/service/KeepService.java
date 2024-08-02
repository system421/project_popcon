package com.store.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;

import com.store.dto.KeepDTO;
import com.store.dto.SkuDTO;
import com.store.entity.Keep;

public interface KeepService {
	List<KeepDTO> findAll();
	Keep addToFridge(KeepDTO keep);
	Keep updateFridge(KeepDTO keep);
	void deleteFromFridge(int fridgeIdx);
}
