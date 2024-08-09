package com.store.mapper;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.store.dto.CartDTO;
import com.store.dto.CartItemDTO;
import com.store.dto.CustomerDTO;
import com.store.dto.SkuDTO;

@Mapper
public interface CartMapper {

	 List<CartDTO> findCartsByCustomerIdx(int customerIdx);
	 List<CartItemDTO> findAll();
}

