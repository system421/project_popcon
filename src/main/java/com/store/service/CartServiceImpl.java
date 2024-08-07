package com.store.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.store.dto.CartDTO;
import com.store.dto.CartItemDTO;
import com.store.entity.CartEntity;
import com.store.entity.CartItemEntity;
import com.store.mapper.CartMapper;
import com.store.repository.CartRepository;
<<<<<<< HEAD
import com.store.repository.CustomerRepository;
import com.store.repository.SkuRepository;

import lombok.AllArgsConstructor;
=======
import com.store.repository.CartItemRepository;
import com.store.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
>>>>>>> d4cc65b (카트 오류 해결 (나머지는 DB 쿼리 문제))

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CartMapper cartMapper;

    public CartServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    @Transactional
    public CartDTO createCart(CartDTO cartDTO) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setCustomerIdx(cartDTO.getCustomerIdx());
        cartEntity.setCreatedDate(LocalDateTime.now());
        cartEntity.setUpdatedDate(LocalDateTime.now());
        cartEntity = cartRepository.save(cartEntity);

        List<CartItemEntity> cartItems = new ArrayList<>();
        for (CartItemDTO cartItemDTO : cartDTO.getCartItems()) {
            CartItemEntity cartItemEntity = new CartItemEntity();
            cartItemEntity.setCartIdx(cartEntity.getCartIdx());
            cartItemEntity.setSkuIdx(cartItemDTO.getSkuIdx());
            cartItemEntity.setSkuValue(cartItemDTO.getSkuValue());
            cartItems.add(cartItemEntity);
        }

        cartItemRepository.saveAll(cartItems);
        
        return CartDTO.of(cartEntity, cartItems);
    }

    @Override
    @Transactional
    public CartDTO updateCart(int cartIdx, CartDTO cartDTO) {
        CartEntity cartEntity = cartRepository.findById(cartIdx)
            .orElseThrow(() -> new RuntimeException("Cart not found"));
        
        cartEntity.setCustomerIdx(cartDTO.getCustomerIdx());
        cartEntity.setUpdatedDate(LocalDateTime.now());
        cartRepository.save(cartEntity);

        cartItemRepository.deleteByCartIdx(cartIdx);

        List<CartItemEntity> cartItems = new ArrayList<>();
        for (CartItemDTO cartItemDTO : cartDTO.getCartItems()) {
            CartItemEntity cartItemEntity = new CartItemEntity();
            cartItemEntity.setCartIdx(cartIdx);
            cartItemEntity.setSkuIdx(cartItemDTO.getSkuIdx());
            cartItemEntity.setSkuValue(cartItemDTO.getSkuValue());
            cartItems.add(cartItemEntity);
        }

        cartItemRepository.saveAll(cartItems);
        
        return CartDTO.of(cartEntity, cartItems);
    }

    @Override
    @Transactional
    public void deleteCart(int cartIdx) {
        cartItemRepository.deleteByCartIdx(cartIdx);
        cartRepository.deleteById(cartIdx);
    }

    @Override
    public List<CartDTO> getCartsByCustomerIdx(int customerIdx) {
        return cartMapper.findCartsByCustomerIdx(customerIdx);
    }

    @Override
    @Transactional
    public CartItemEntity addToCart(CartItemDTO cartItemDTO) {
        CartItemEntity cartItemEntity = new CartItemEntity();
        cartItemEntity.setCartIdx(cartItemDTO.getCartIdx());
        cartItemEntity.setSkuIdx(cartItemDTO.getSkuIdx());
        cartItemEntity.setSkuValue(cartItemDTO.getSkuValue());

        return cartItemRepository.save(cartItemEntity);
    }
}
