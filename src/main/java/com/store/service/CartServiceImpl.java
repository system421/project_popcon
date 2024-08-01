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
import com.store.entity.Cart;
import com.store.entity.Customer;
import com.store.entity.Sku;
import com.store.mapper.CartMapper;
import com.store.mapper.MemberMapper;
import com.store.mapper.SkuMapper;
import com.store.repository.CartRepository;
import com.store.repository.CustomerRepository;
import com.store.repository.SkuRepository;
import com.store.service.MemberService;
@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartMapper cartMapper;
	
	  @Autowired
	    private CartRepository cartRepository;

	    @Autowired
	    private CustomerRepository customerRepository;

	    @Autowired
	    private SkuRepository skuRepository;

	    @Override
	    public List<CartDTO> findAll() {
	        List<CartDTO> carts = cartMapper.findAll();
	        if (carts == null) {
	            throw new NullPointerException("Cart list is null");
	        }
	        return carts;
	    }

	    
	    @Override
	    public Cart addToCart(CartDTO cartDto) {
	        Cart cart = convertToEntity(cartDto);
	        return cartRepository.save(cart);
	    }

	    @Override
	    public Cart updateCart(CartDTO cartDto) {
	        Cart existingCart = cartRepository.findById(cartDto.getCartIdx())
	                .orElseThrow(() -> new IllegalArgumentException("Invalid cart ID: " + cartDto.getCartIdx()));

	        existingCart.setSkuValue(cartDto.getSkuValue());

	        Customer customer = customerRepository.findById(cartDto.getCustomerIdx())
	                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + cartDto.getCustomerIdx()));
	        Sku sku = skuRepository.findById(cartDto.getSkuIdx())
	                .orElseThrow(() -> new IllegalArgumentException("Invalid SKU ID: " + cartDto.getSkuIdx()));

	        existingCart.setCustomer(customer);
	        existingCart.setSku(sku);

	        return cartRepository.save(existingCart);
	    }

	    @Override
	    public void deleteFromCart(int cartIdx) {
	        cartRepository.deleteById(cartIdx);
	    }

	    private Cart convertToEntity(CartDTO cartDto) {
	        Cart cart = new Cart();

	        Customer customer = customerRepository.findById(cartDto.getCustomerIdx())
	                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + cartDto.getCustomerIdx()));
	        Sku sku = skuRepository.findById(cartDto.getSkuIdx())
	                .orElseThrow(() -> new IllegalArgumentException("Invalid SKU ID: " + cartDto.getSkuIdx()));

	        cart.setCustomer(customer);
	        cart.setSku(sku);
	        cart.setSkuValue(cartDto.getSkuValue());

	        return cart;
	    }

		
}
	

	

