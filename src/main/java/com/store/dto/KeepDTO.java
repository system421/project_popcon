package com.store.dto;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;

@Alias("Keep")
public class KeepDTO {
	
	private int fridgeIdx;
	private int skuIdx;
	private int customerIdx;
	public KeepDTO(int fridgeIdx, int skuIdx, int customerIdx) {
		super();
		this.fridgeIdx = fridgeIdx;
		this.skuIdx = skuIdx;
		this.customerIdx = customerIdx;
	}
	public KeepDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFridgeIdx() {
		return fridgeIdx;
	}
	public void setFridgeIdx(int fridgeIdx) {
		this.fridgeIdx = fridgeIdx;
	}
	public int getSkuIdx() {
		return skuIdx;
	}
	public void setSkuIdx(int skuIdx) {
		this.skuIdx = skuIdx;
	}
	public int getCustomerIdx() {
		return customerIdx;
	}
	public void setCustomerIdx(int customerIdx) {
		this.customerIdx = customerIdx;
	}
	
}
