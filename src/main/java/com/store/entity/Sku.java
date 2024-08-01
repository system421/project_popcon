package com.store.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "Sku")
public class Sku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sku_idx")
    private int skuIdx;

    @Column(name = "sku_name")
    private String skuName;
    @Column(name = "sku_cost")
    private int skuCost;
    @Column(name = "sku_barcode")
    private String skuBarcode;

  
}