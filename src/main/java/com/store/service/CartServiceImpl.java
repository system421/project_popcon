package com.store.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.store.dto.CartDTO;
import com.store.entity.CartEntity;
import com.store.entity.CartItemEntity;
import com.store.mapper.CartMapper;
import com.store.repository.CartItemRepository;
import com.store.repository.CartRepository;
import com.store.repository.CustomerRepository;
import com.store.repository.SkuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartMapper cartMapper;
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final SkuRepository skuRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    public CartDTO findById(Integer id) {
        // onetomany, manytoone 관계보다는, 로직에서 따로 CRUD 하여 조합하여 처리하는 방식으로 현업에서 더 사용.
        // 이유는, 성능 이슈 (JPA N+1 문제)가 발생할 수 있기 때문입니다.
        CartEntity cartEntity = cartRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid cart ID: " + id));
        List<CartItemEntity> cartItemEntities = cartItemRepository.findByCartIdx(id);

        // 이제부터는, 프리젠테이션 레이어에서 사용할 DTO로 변환하는 작업을 해야 합니다.
        return CartDTO.of(cartEntity, cartItemEntities);
    }

    @Override
    public List<CartDTO> findAll() {
        List<CartDTO> carts = cartMapper.findAll();
        if (carts == null) {
            throw new NullPointerException("Cart list is null");
        }
        return carts;
    }

    @Override
    @Transactional
    public CartDTO createCart(CartDTO cartDTO) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setCustomerIdx(cartDTO.getCustomerIdx());
        cartRepository.save(cartEntity);

        List<CartItemEntity> cartItemEntities = cartDTO.getCartItems().stream()
                .map(itemDTO -> {
                    CartItemEntity itemEntity = new CartItemEntity();
                    itemEntity.setCart(cartEntity);
                    itemEntity.setSkuIdx(itemDTO.getSkuIdx());
                    itemEntity.setSkuValue(itemDTO.getSkuValue());
                    itemEntity.setSkuName(itemDTO.getSkuName());
                    itemEntity.setSkuBarcode(itemDTO.getSkuBarcode());
                    itemEntity.setSkuCost(itemDTO.getSkuCost());
                    return itemEntity;
                }).collect(Collectors.toList());

        cartItemRepository.saveAll(cartItemEntities);

        return CartDTO.of(cartEntity, cartItemEntities);
    }

    @Override
    @Transactional
    public CartDTO updateCart(CartDTO cartDTO) {
        CartEntity cartEntity = cartRepository.findById(cartDTO.getCartIdx()).orElseThrow();
        cartEntity.setCustomerIdx(cartDTO.getCustomerIdx());
        cartRepository.save(cartEntity);

        cartItemRepository.deleteByCartId(cartDTO.getCartIdx());

        List<CartItemEntity> cartItemEntities = cartDTO.getCartItems().stream()
                .map(itemDTO -> {
                    CartItemEntity itemEntity = new CartItemEntity();
                    itemEntity.setCart(cartEntity);
                    itemEntity.setSkuIdx(itemDTO.getSkuIdx());
                    itemEntity.setSkuValue(itemDTO.getSkuValue());
                    itemEntity.setSkuName(itemDTO.getSkuName());
                    itemEntity.setSkuBarcode(itemDTO.getSkuBarcode());
                    itemEntity.setSkuCost(itemDTO.getSkuCost());
                    return itemEntity;
                }).collect(Collectors.toList());

        cartItemRepository.saveAll(cartItemEntities);

        return CartDTO.of(cartEntity, cartItemEntities);
    }

    @Override
    @Transactional
    public void deleteCart(int cartIdx) {
        cartItemRepository.deleteByCartId(cartIdx);
        cartRepository.deleteById(cartIdx);
    }
}
