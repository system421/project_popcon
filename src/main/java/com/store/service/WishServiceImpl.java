package com.store.service;

import com.store.dto.WishDTO;
import com.store.dto.WishItemDTO;
import com.store.entity.Wish;
import com.store.entity.WishItemEntity;

import com.store.entity.CartEntity;
import com.store.entity.CartItemEntity;
import com.store.entity.Customer;
import com.store.mapper.WishMapper;
import com.store.repository.WishRepository;
import com.store.repository.CartItemRepository;

import com.store.repository.CustomerRepository;
import com.store.repository.WishItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishServiceImpl implements WishService {

    private final WishRepository wishRepository;
    private final WishItemRepository wishItemRepository;
    private final WishMapper wishMapper;
    private final CustomerRepository customerRepository;

    private final CartItemRepository cartItemRepository;
    
    public WishServiceImpl(WishRepository wishRepository, WishItemRepository wishItemRepository, WishMapper wishMapper, CustomerRepository customerRepository, CartItemRepository cartItemRepository) {
        this.wishRepository = wishRepository;
        this.wishItemRepository = wishItemRepository;
        this.wishMapper = wishMapper;
        this.customerRepository = customerRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public WishDTO createWish(WishDTO wishDTO) {
        // Customer를 찾아서 설정
        Customer customer = customerRepository.findById(wishDTO.getCustomerIdx())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Wish wishEntity = new Wish();
        wishEntity.setCustomer(customer);
        wishEntity.setCreatedDate(LocalDateTime.now());
        wishEntity.setUpdatedDate(LocalDateTime.now());
        wishEntity = wishRepository.save(wishEntity);

        List<WishItemEntity> wishItems = new ArrayList<>();
        for (WishItemDTO wishItemDTO : wishDTO.getWishItems()) {
            WishItemEntity wishItemEntity = new WishItemEntity();
            wishItemEntity.setWish(wishEntity);
            wishItemEntity.setSkuIdx(wishItemDTO.getSkuIdx());
            wishItems.add(wishItemEntity);
        }


        wishItemRepository.saveAll(wishItems);
        
        return WishDTO.of(wishEntity, wishItems); // WishDTO.of() 메서드는 WishEntity와 WishItemEntities를 기반으로 DTO를 만들어야 합니다.
    }

    @Override
    public WishItemDTO updateWishItemQuantity(int wishItemIdx) {
        WishItemEntity wishItemEntity = wishItemRepository.findById(wishItemIdx)
                .orElseThrow(() -> new RuntimeException("WishItem not found"));

        wishItemEntity = wishItemRepository.save(wishItemEntity);

        return WishItemDTO.of(wishItemEntity);
    }


    @Override
    @Transactional
    public void deleteWishItem(int wishItemIdx) {
        wishItemRepository.deleteById(wishItemIdx);
    }

    @Override

    public List<WishDTO> getWishesByCustomerIdx(int customerIdx) {
        return wishMapper.getWishesByCustomerIdx(customerIdx);
    }

    @Override
    @Transactional
    public WishItemEntity addToWish(WishItemDTO wishItemDTO) {
        // Check if the wish exists
        Wish wishEntity = wishRepository.findById(wishItemDTO.getWishIdx())
            .orElseThrow(() -> new RuntimeException("Wish not found"));

        // Check if the item with the same skuIdx exists in the wish
        Optional<WishItemEntity> existingWishItem = wishItemRepository
            .findByWishWishIdxAndSkuIdx(wishEntity.getWishIdx(), wishItemDTO.getSkuIdx());

        if (existingWishItem.isPresent()) {
            // If the item exists, increase the count
            WishItemEntity wishItemEntity = existingWishItem.get();// Increase the count by 1
            return wishItemRepository.save(wishItemEntity);
        } else {
            // If the item does not exist, create a new one with count 1
            WishItemEntity wishItemEntity = new WishItemEntity();
            wishItemEntity.setWish(wishEntity);
            wishItemEntity.setSkuIdx(wishItemDTO.getSkuIdx());
            return wishItemRepository.save(wishItemEntity);
        }
    }

    @Override
    public List<WishItemDTO> findAll() {
        return wishMapper.findAll();
    }

    @Override
    @Transactional
    public void moveWishToCart(int wishItemIdx, int cartIdx) {
        // 찜한 항목 가져오기
        WishItemEntity wishItem = wishItemRepository.findById(wishItemIdx)
                .orElseThrow(() -> new RuntimeException("Wish item not found"));

     // CartEntity 객체 생성 및 cartIdx 설정
        CartEntity cartEntity = new CartEntity();
        cartEntity.setCartIdx(cartIdx);

        // 장바구니 항목 생성 및 저장
        CartItemEntity cartItem = CartItemEntity.builder()
                .cart(cartEntity)
                .skuIdx(wishItem.getSkuIdx())
                .skuValue(1)  // 기본 수량을 1로 설정, 필요시 수정 가능
                .build();
        
        cartItemRepository.save(cartItem);

        // 찜 항목 삭제
        wishItemRepository.deleteByWishWishIdx(wishItemIdx);
    }

	
}
