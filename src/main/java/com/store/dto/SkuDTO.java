package com.store.dto;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("Sku")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SkuDTO {

	private int skuIdx;
	private int skuTypeIdx;
	private String skuName;
	private int skuCost;
	private String skuBarcode;
	private int promotionIdx;
	private int favorite;

}
