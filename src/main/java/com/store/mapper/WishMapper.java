package com.store.mapper;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.store.dto.CartDTO;
import com.store.dto.SkuDTO;
import com.store.dto.WishDTO;
import com.store.dto.WishItemDTO;

@Mapper
public interface WishMapper {
	List<WishItemDTO> findAll();
	List<WishDTO>getWishesByCustomerIdx(int customerIdx);
}

