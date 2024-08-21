package com.store.service;

import com.store.dto.KeepDTO;
import com.store.dto.KeepItemDTO;
import com.store.entity.Keep;
import com.store.entity.KeepItemEntity;
import com.store.entity.CartEntity;
import com.store.entity.CartItemEntity;
import com.store.entity.Customer;
import com.store.mapper.KeepMapper;
import com.store.repository.CartItemRepository;
import com.store.repository.CartRepository;
import com.store.repository.CustomerRepository;
import com.store.repository.KeepItemRepository;
import com.store.repository.KeepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KeepServiceImpl implements KeepService {

    private final KeepRepository keepRepository;
    private final KeepItemRepository keepItemRepository;
    private final KeepMapper keepMapper;
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    @Autowired
    public KeepServiceImpl(KeepRepository keepRepository, KeepItemRepository keepItemRepository, KeepMapper keepMapper, CustomerRepository customerRepository,CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.keepRepository = keepRepository;
        this.keepItemRepository = keepItemRepository;
        this.keepMapper = keepMapper;
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }


    @Override
    @Transactional
    public KeepDTO createKeep(KeepDTO keepDTO) {
        Customer customer = customerRepository.findById(keepDTO.getCustomerIdx())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Keep keepEntity = new Keep();
        keepEntity.setCustomer(customer);
        keepEntity.setCreatedDate(LocalDateTime.now());
        keepEntity.setKeepDate(LocalDateTime.now());
        keepEntity = keepRepository.save(keepEntity);

        List<KeepItemEntity> keepItems = new ArrayList<>();
        for (KeepItemDTO keepItemDTO : keepDTO.getKeepItems()) {
            KeepItemEntity keepItemEntity = new KeepItemEntity();
            keepItemEntity.setKeep(keepEntity);
            keepItemEntity.setSkuIdx(keepItemDTO.getSkuIdx());
            keepItemEntity.setQty(keepItemDTO.getQty());
            keepItems.add(keepItemEntity);
        }

        keepItemRepository.saveAll(keepItems);

        return KeepDTO.of(keepEntity, keepItems);
    }

    @Override
    @Transactional
    public KeepItemDTO updateKeepItemQuantity(int keepItemIdx, int qty) {
        KeepItemEntity keepItemEntity = keepItemRepository.findById(keepItemIdx)
                .orElseThrow(() -> new RuntimeException("KeepItem not found"));

        keepItemEntity.setQty(qty);
        keepItemEntity = keepItemRepository.save(keepItemEntity);

        return KeepItemDTO.of(keepItemEntity);
    }

    @Override
    public List<KeepDTO> getKeepByCustomerIdx(int customerIdx) {
        return keepMapper.findKeepByCustomerIdx(customerIdx);
    }

    @Override
    public void deleteFromFridge(int fridgeIdx) {
        keepItemRepository.deleteByKeepFridgeIdx(fridgeIdx);
    }

    @Override
    public KeepItemEntity addToKeep(KeepItemDTO keepItemDTO) {
        KeepItemEntity keepItemEntity = new KeepItemEntity();
        keepItemEntity.setSkuIdx(keepItemDTO.getSkuIdx());
        keepItemEntity.setQty(keepItemDTO.getQty());
        // fridgeIdx나 customerIdx에 해당하는 Keep 설정 추가 필요
        return keepItemRepository.save(keepItemEntity);
    }

    @Override
    @Transactional
    public void moveItemsToCart(int keepItemIdx, int cartIdx) {
        // keepItemIdx로 keepitem 조회
        KeepItemEntity keepItem = keepItemRepository.findById(keepItemIdx)
                .orElseThrow(() -> new RuntimeException("Keep Item not found"));

        // cartEntity 객체를 생성하고 cartIdx를 설정
        CartEntity cartEntity = cartRepository.findById(cartIdx)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        // cart 항목 생성 및 저장
        CartItemEntity cartItem = CartItemEntity.builder()
                .cart(cartEntity)
                .skuIdx(keepItem.getSkuIdx())
                .skuValue(keepItem.getQty())
                .keepCost(BigDecimal.ZERO)  
                .source("KEEP") // SKU 비용을 0으로 강제 설정
                .build();

        cartItemRepository.save(cartItem);
        System.out.println("Cart Item Saved with skuCost: " + cartItem.getKeepCost ());
        // keepitem에서 해당 아이템 삭제
        keepItemRepository.delete(keepItem);
    }


    @Override
    public List<KeepItemDTO> findAll(){
    	return keepMapper.findAll();
    }
    
}
