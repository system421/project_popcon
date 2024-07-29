package com.exam.dto;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;

@Alias("Sku")
public class Sku {
	
	
	private int skuIdx;
	private int skuTypeIdx;
	private String skuName;
	private int skuCost;
	private String skuBarcode;
	public Sku(int skuIdx, int skuTypeIdx, String skuName, int skuCost, String skuBarcode) {
		super();
		this.skuIdx = skuIdx;
		this.skuTypeIdx = skuTypeIdx;
		this.skuName = skuName;
		this.skuCost = skuCost;
		this.skuBarcode = skuBarcode;
	}
	public Sku() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSkuIdx() {
		return skuIdx;
	}
	public void setSkuIdx(int skuIdx) {
		this.skuIdx = skuIdx;
	}
	public int getSkuTypeIdx() {
		return skuTypeIdx;
	}
	public void setSkuTypeIdx(int skuTypeIdx) {
		this.skuTypeIdx = skuTypeIdx;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public int getSkuCost() {
		return skuCost;
	}
	public void setSkuCost(int skuCost) {
		this.skuCost = skuCost;
	}
	public String getSkuBarcode() {
		return skuBarcode;
	}
	public void setSkuBarcode(String skuBarcode) {
		this.skuBarcode = skuBarcode;
	}
	

    
}
