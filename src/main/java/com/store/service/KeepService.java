package com.store.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;

import com.store.dto.KeepDTO;
import com.store.dto.KeepItemDTO;
import com.store.dto.SkuDTO;
import com.store.entity.Keep;
import com.store.entity.KeepItemEntity;

public interface KeepService {
	KeepDTO createKeep(KeepDTO keepDTO);
    KeepItemDTO updateKeepItemQuantity(int keepItemIdx, int qty);
    List<KeepDTO> getKeepByCustomerIdx(int customerIdx);
    void deleteFromFridge(int fridgeIdx);
    KeepItemEntity addToKeep(KeepItemDTO keepItemDTO);
    List<KeepItemDTO> findAll();
    
    void moveItemsToCart(int keepItemIdx, int cartIdx);
    
}
