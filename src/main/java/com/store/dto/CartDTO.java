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
@Alias("Cart")
public class CartDTO {

	private int cartIdx;
	private int customerIdx;
	private List<CartItemDTO> cartItems;

	public static CartDTO of(CartEntity cartEntity, List<CartItemEntity> itemEntities) {
		CartDTO cart = new CartDTO();
		cart.setCartIdx(cartEntity.getCartIdx());
		cart.setCustomerIdx(cartEntity.getCustomer().getCustomerIdx());
		cart.cartItems = new ArrayList<>();
		for (CartItemEntity itemEntity : itemEntities) {
			cart.getCartItems().add(CartItemDTO.of(itemEntity));
		}
		return cart;
	}

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CartItemDTO {
		private int cartItemIdx;
		private int skuIdx;
		private int skuValue; // 수량
		private String skuName;
		private String skuBarcode;
		private Integer skuCost;

		public static CartItemDTO of(CartItemEntity itemEntity) {
			CartItemDTO item = new CartItemDTO();
			item.setCartItemIdx(itemEntity.getCartItemIdx());
			item.setSkuIdx(itemEntity.getSku().getSkuIdx());
			item.setSkuValue(itemEntity.getSkuValue());
			item.setSkuName(itemEntity.getSku().getSkuName());
			item.setSkuBarcode(itemEntity.getSku().getSkuBarcode());
			item.setSkuCost(itemEntity.getSku().getSkuCost());
			return item;
		}
	}
}