package com.store.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;

import com.store.dto.CartDTO;
import com.store.dto.MemberDTO;
import com.store.dto.PayOrderDTO;
import com.store.dto.SkuDTO;
import com.store.entity.Cart;
import com.store.entity.PayOrder;

public interface PayOrderService {
	List<PayOrderDTO> findAll();
	PayOrder save(PayOrder payOrder);
    void deleteById(int id);
	
}
