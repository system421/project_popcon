package com.store.dto;

import com.store.entity.CartEntity;
import com.store.entity.CartItemEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Alias("Cart")
public class CartDTO {

    private int cartIdx;
    private int customerIdx;
    private List<CartItemDTO> cartItems;

    public static CartDTO of(CartEntity cartEntity, List<CartItemEntity> itemEntities) {
        CartDTO cart = new CartDTO();
        cart.setCartIdx(cartEntity.getCartIdx());
        cart.setCustomerIdx(cartEntity.getCustomerIdx());
        cart.setCartItems(new ArrayList<>());
        for (CartItemEntity itemEntity : itemEntities) {
            cart.getCartItems().add(CartItemDTO.of(itemEntity));
        }
        return cart;
    }
}
