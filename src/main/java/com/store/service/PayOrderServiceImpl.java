package com.store.service;

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

import com.store.dto.CartDTO;
import com.store.dto.MemberDTO;
import com.store.dto.PayOrderDTO;
import com.store.dto.SkuDTO;
import com.store.entity.Cart;
import com.store.entity.Customer;
import com.store.entity.PayOrder;
import com.store.entity.Sku;
import com.store.mapper.CartMapper;
import com.store.mapper.MemberMapper;
import com.store.mapper.PayOrderMapper;
import com.store.mapper.SkuMapper;
import com.store.repository.CartRepository;
import com.store.repository.CustomerRepository;
import com.store.repository.PayOrderRepository;
import com.store.repository.SkuRepository;
import com.store.service.MemberService;
@Service
public class PayOrderServiceImpl implements PayOrderService{

	  private final PayOrderRepository payOrderRepository;
	    private final PayOrderMapper payOrderMapper;

	    @Autowired
	    public PayOrderServiceImpl(PayOrderRepository payOrderRepository, PayOrderMapper payOrderMapper) {
	        this.payOrderRepository = payOrderRepository;
	        this.payOrderMapper = payOrderMapper;
	    }

	    @Override
	    public List<PayOrderDTO> findAll() {
	        return payOrderMapper.findAll();
	    }

	    @Override
	    public PayOrder save(PayOrder payOrder) {
	        return payOrderRepository.save(payOrder);
	    }

	    @Override
	    public void deleteById(int id) {
	        payOrderRepository.deleteById(id);
	    }
		
}
	

	

