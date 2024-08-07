package com.store.dto;

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

    public static CartItemDTO of(CartItemEntity itemEntity) {
        CartItemDTO item = new CartItemDTO();
        item.setCartItemIdx(itemEntity.getCartItemIdx());
        item.setCartIdx(itemEntity.getCartIdx());  // 추가된 필드 설정
        item.setSkuIdx(itemEntity.getSkuIdx());
        item.setSkuValue(itemEntity.getSkuValue());
        return item;
    }
}
