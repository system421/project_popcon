
package com.store.entity;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
public class CartItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name = "cart_item_idx")
	private int cartItemIdx;

	@Column(nullable = false, name = "cart_idx")
	private int cartIdx;

	@ManyToOne
	@JoinColumn(name = "sku_idx", nullable = false)
	private Sku sku;

	@Column(name = "sku_value", nullable = false)
	private int skuValue;
}
