package com.store.service;

import com.store.dto.CartDTO;
import com.store.dto.CartItemDTO;
import com.store.dto.KeepItemDTO;
import com.store.entity.CartEntity;
import com.store.entity.CartItemEntity;
import com.store.entity.Customer;
import com.store.entity.Keep;
import com.store.entity.KeepItemEntity;
import com.store.mapper.CartMapper;
import com.store.repository.CartRepository;
import com.store.repository.CustomerRepository;
import com.store.repository.KeepItemRepository;
import com.store.repository.KeepRepository;
import com.store.repository.CartItemRepository;
import com.store.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CartMapper cartMapper;
    private final CustomerRepository customerRepository;
    private final KeepService keepservice;
    private final KeepItemRepository keepItemRepository;
    public CartServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository, CartMapper cartMapper, CustomerRepository customerRepository,  KeepService keepService, KeepItemRepository keepItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartMapper = cartMapper;
        this.customerRepository = customerRepository;
        this.keepservice = keepService;
        this.keepItemRepository = keepItemRepository;
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

        // Check if the item with the same skuIdx and source exists in the cart
        Optional<CartItemEntity> existingCartItem = cartItemRepository
            .findByCartCartIdxAndSkuIdxAndSource(cartEntity.getCartIdx(), cartItemDTO.getSkuIdx(), "SKU");

        if (existingCartItem.isPresent()) {
            // If the item exists, increase the count
            CartItemEntity cartItemEntity = existingCartItem.get();
            cartItemEntity.setSkuValue(cartItemEntity.getSkuValue() + 1); // Increase the count by 1
            return cartItemRepository.save(cartItemEntity);
        } else {
            // If the item does not exist, create a new one with count 1
            CartItemEntity cartItemEntity = CartItemEntity.builder()
                .cart(cartEntity)
                .skuIdx(cartItemDTO.getSkuIdx())
                .skuValue(1) // Set initial count to 1
                .source("SKU") // Set the source to "SKU"
                .build();
            return cartItemRepository.save(cartItemEntity);
        }
    }


    @Override
    public List<CartItemDTO> findAll() {
        return cartMapper.findAll();
    }
    @Override
    @Transactional
    public void moveToKeep(int cartItemIdx, int fridgeIdx, int qty) {
        // cartItemIdx로 카트 아이템을 조회
        CartItemEntity cartItem = cartItemRepository.findById(cartItemIdx)
            .orElseThrow(() -> new RuntimeException("Cart item not found"));

        // 실제 이동하려는 수량이 현재 카트에 있는 수량보다 많은 경우 처리
        int actualQtyToMove = Math.min(qty, cartItem.getSkuValue());

        // KeepEntity 객체 생성 및 fridgeIdx 설정
        Keep keepEntity = new Keep();
        keepEntity.setFridgeIdx(fridgeIdx);

        // 킵 항목 생성 및 저장
        KeepItemEntity keepItem = KeepItemEntity.builder()
                .keep(keepEntity)
                .skuIdx(cartItem.getSkuIdx())
                .qty(actualQtyToMove)
                .build();
        
        keepItemRepository.save(keepItem);

        // 카트 아이템 수량을 줄이거나 삭제
        if (cartItem.getSkuValue() > actualQtyToMove) {
            cartItem.setSkuValue(cartItem.getSkuValue() - actualQtyToMove);
            cartItemRepository.save(cartItem);
        } else {
            cartItemRepository.delete(cartItem);
        }
    }





    @Override
    @Transactional
    public void clearCartByCustomerIdx(int customerIdx) {
        cartItemRepository.deleteByCartCustomerCustomerIdx(customerIdx);
    }
    @Override
    public List<CartItemEntity> findCartItemsByCustomerIdx(int customerIdx) {
        return cartItemRepository.findByCartCustomerCustomerIdx(customerIdx);
    }
    @Override
    public void deleteCartItemsByCustomerIdx(int customerIdx, List<Integer> excludeSkuIds) {
        List<CartItemEntity> cartItems = cartItemRepository.findByCartCustomerCustomerIdx(customerIdx);
        for (CartItemEntity cartItem : cartItems) {
            if (!excludeSkuIds.contains(cartItem.getSkuIdx())) {
                cartItemRepository.delete(cartItem);
            }
        }
    }
    @Override
    public List<CartItemDTO> getCartItems(int cartIdx) {
        List<CartItemEntity> cartItems = cartMapper.selectCartItemsByCartIdx(cartIdx);
        return cartItems.stream().map(CartItemDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void moveKeepItemToCart(int keepItemIdx, int cartIdx, int quantity) {
        // KeepItem에서 해당 아이템을 조회
        KeepItemEntity keepItem = keepItemRepository.findById(keepItemIdx)
                .orElseThrow(() -> new RuntimeException("Keep item not found"));

        CartEntity cartEntity = cartRepository.findById(cartIdx)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        CartItemEntity cartItem = CartItemEntity.builder()
                .cart(cartEntity)
                .skuIdx(keepItem.getSkuIdx())
                .skuValue(keepItem.getQty())
                .keepCost(BigDecimal.ZERO)
                .source("KEEP") 
                .build();

        cartItemRepository.save(cartItem);

        // KeepItem의 수량을 차감 또는 삭제
        if (keepItem.getQty() > quantity) {
            keepItem.setQty(keepItem.getQty() - quantity);
            keepItemRepository.save(keepItem);
        } else {
            keepItemRepository.delete(keepItem);
        }
    }
}