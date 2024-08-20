package com.store.dto;

import java.math.BigDecimal;

import com.store.entity.CartItemEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private int cartItemIdx;
    private int cartIdx;  // 추가된 필드
    private int skuIdx;
    private int skuValue; // 수량
    private String skuName;
    private Integer skuCost;
    private Integer keepCost;  // Keep에서 넘어온 상품의 가격
    private Integer finalCost;
    private String source;  
    public static CartItemDTO of(CartItemEntity itemEntity) {
        if (itemEntity == null) {
            return null;
        }
        CartItemDTO item = new CartItemDTO();
        item.setCartItemIdx(itemEntity.getCartItemIdx());
        item.setCartIdx(itemEntity.getCart().getCartIdx());  // 추가된 필드 설정
        item.setSkuIdx(itemEntity.getSkuIdx());
        item.setSkuValue(itemEntity.getSkuValue());
        
        return item;
    }
}
