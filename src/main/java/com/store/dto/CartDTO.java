package com.store.dto;

import java.util.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@Alias("Cart")
public class CartDTO {

	private int cartIdx;
    private int customerIdx;
    private int skuIdx;
    private int skuValue;
    private String skuName;
    private String skuBarcode;
    private Integer skuCost;
	
}
