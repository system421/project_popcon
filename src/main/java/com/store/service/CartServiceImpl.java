package com.store.service;

import com.store.dto.CartDTO;
import com.store.dto.CartItemDTO;
import com.store.entity.CartEntity;
import com.store.entity.CartItemEntity;
import com.store.entity.Customer;
import com.store.mapper.CartMapper;
import com.store.repository.CartRepository;
import com.store.repository.CustomerRepository;
import com.store.repository.CartItemRepository;
import com.store.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CartMapper cartMapper;
    private final CustomerRepository customerRepository;
    public CartServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository, CartMapper cartMapper, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartMapper = cartMapper;
        this.customerRepository = customerRepository;
    }
    @Override
    @Transactional
    public CartDTO createCart(CartDTO cartDTO) {
        // Customer를 찾아서 설정
        Customer customer = customerRepository.findById(cartDTO.getCustomerIdx())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        CartEntity cartEntity = new CartEntity();
        cartEntity.setCustomer(customer);
        cartEntity.setCreatedDate(LocalDateTime.now());
        cartEntity.setUpdatedDate(LocalDateTime.now());
        cartEntity = cartRepository.save(cartEntity);

        List<CartItemEntity> cartItems = new ArrayList<>();
        for (CartItemDTO cartItemDTO : cartDTO.getCartItems()) {
            CartItemEntity cartItemEntity = new CartItemEntity();
            cartItemEntity.setCart(cartEntity);
            cartItemEntity.setSkuIdx(cartItemDTO.getSkuIdx());
            cartItemEntity.setSkuValue(cartItemDTO.getSkuValue());
            cartItems.add(cartItemEntity);
        }

        cartItemRepository.saveAll(cartItems);
        
        return CartDTO.of(cartEntity, cartItems); // CartDTO.of() 메서드는 CartEntity와 CartItemEntities를 기반으로 DTO를 만들어야 합니다.
    }


    @Override
    public CartItemDTO updateCartItemQuantity(int cartItemIdx, int skuValue) {
        CartItemEntity cartItemEntity = cartItemRepository.findById(cartItemIdx)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));


        cartItemEntity.setSkuValue(skuValue);
        cartItemEntity = cartItemRepository.save(cartItemEntity);

        return CartItemDTO.of(cartItemEntity);

    }

    @Override
    @Transactional

    public void deleteCartItem(int cartItemIdx) {
        cartItemRepository.deleteById(cartItemIdx);

    }

    @Override
    public List<CartDTO> getCartsByCustomerIdx(int customerIdx) {
        return cartMapper.findCartsByCustomerIdx(customerIdx);
    }

    @Override
    @Transactional
    public CartItemEntity addToCart(CartItemDTO cartItemDTO) {
        // Check if the cart exists
        CartEntity cartEntity = cartRepository.findById(cartItemDTO.getCartIdx())
            .orElseThrow(() -> new RuntimeException("Cart not found"));

        // Check if the item with the same skuIdx exists in the cart
        Optional<CartItemEntity> existingCartItem = cartItemRepository
            .findByCartCartIdxAndSkuIdx(cartEntity.getCartIdx(), cartItemDTO.getSkuIdx());

        if (existingCartItem.isPresent()) {
            // If the item exists, increase the count
            CartItemEntity cartItemEntity = existingCartItem.get();
            cartItemEntity.setSkuValue(cartItemEntity.getSkuValue() + 1); // Increase the count by 1
            return cartItemRepository.save(cartItemEntity);
        } else {
            // If the item does not exist, create a new one with count 1
            CartItemEntity cartItemEntity = new CartItemEntity();
            cartItemEntity.setCart(cartEntity);
            cartItemEntity.setSkuIdx(cartItemDTO.getSkuIdx());
            cartItemEntity.setSkuValue(1); // Set initial count to 1
            return cartItemRepository.save(cartItemEntity);
        }

    }
    @Override
    public List<CartItemDTO> findAll() {
        return cartMapper.findAll();

    }
}
