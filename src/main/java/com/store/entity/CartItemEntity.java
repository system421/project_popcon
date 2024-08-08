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

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    private int cartItemIdx;

    @ManyToOne
    @JoinColumn(name = "cart_idx", nullable = false)
    @JsonBackReference
    private CartEntity cart;

    @Column(name = "sku_idx")
    private int skuIdx;

    private int skuValue;
	    
}
