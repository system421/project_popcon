package com.store.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "cart_item")
public class CartItemEntity {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="cart_item_idx")
	    private int cartItemIdx;
	    @Column(name = "cart_idx")
	    private int cartIdx;
	    @Column(name = "sku_idx")
	    private int skuIdx;
	    private int skuValue;
}
