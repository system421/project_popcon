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
import com.store.dto.SkuDTO;
import com.store.dto.WishDTO;
import com.store.entity.Cart;
import com.store.entity.Customer;
import com.store.entity.Sku;
import com.store.entity.Wish;
import com.store.mapper.CartMapper;
import com.store.mapper.MemberMapper;
import com.store.mapper.SkuMapper;
import com.store.mapper.WishMapper;
import com.store.repository.CartRepository;
import com.store.repository.CustomerRepository;
import com.store.repository.SkuRepository;
import com.store.repository.WishRepository;
import com.store.service.MemberService;
@Service
public class WishServiceImpl implements WishService{
	
	@Autowired
	WishMapper wishMapper;
	
	  @Autowired
	    private WishRepository wishRepository;

	    @Autowired
	    private CustomerRepository customerRepository;

	    @Autowired
	    private SkuRepository skuRepository;

	    @Override
	    public Wish addToWish(WishDTO wishDto) {
	        Wish wish = convertToEntity(wishDto);
	        return wishRepository.save(wish);
	    }

	
	    @Override
	    public void deleteFromWish(int wishIdx) {
	    	wishRepository.deleteById(wishIdx);
	    }

	    private Wish convertToEntity(WishDTO wishDto) {
	        Wish wish = new Wish();

	        Customer customer = customerRepository.findById(wishDto.getCustomerIdx())
	                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + wishDto.getCustomerIdx()));
	        Sku sku = skuRepository.findById(wishDto.getSkuIdx())
	                .orElseThrow(() -> new IllegalArgumentException("Invalid SKU ID: " + wishDto.getSkuIdx()));

	        wish.setCustomer(customer);
	        wish.setSku(sku);
	  
	        return wish;
	    }

		@Override
		public List<WishDTO> findAll() {
			return wishMapper.findAll();
		}
		
		}
	

	

