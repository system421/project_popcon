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

@Alias("Wish")
public class WishDTO {
	
	   private int wishIdx;
	    private int customerIdx;
	    private int skuIdx;
	    private String skuName;
	    private String skuBarcode;
	    private Integer skuCost;
		public WishDTO(int wishIdx, int customerIdx, int skuIdx, String skuName, String skuBarcode, Integer skuCost) {
			super();
			this.wishIdx = wishIdx;
			this.customerIdx = customerIdx;
			this.skuIdx = skuIdx;
			this.skuName = skuName;
			this.skuBarcode = skuBarcode;
			this.skuCost = skuCost;
		}
		public WishDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getWishIdx() {
			return wishIdx;
		}
		public void setWishIdx(int wishIdx) {
			this.wishIdx = wishIdx;
		}
		public int getCustomerIdx() {
			return customerIdx;
		}
		public void setCustomerIdx(int customerIdx) {
			this.customerIdx = customerIdx;
		}
		public int getSkuIdx() {
			return skuIdx;
		}
		public void setSkuIdx(int skuIdx) {
			this.skuIdx = skuIdx;
		}
		public String getSkuName() {
			return skuName;
		}
		public void setSkuName(String skuName) {
			this.skuName = skuName;
		}
		public String getSkuBarcode() {
			return skuBarcode;
		}
		public void setSkuBarcode(String skuBarcode) {
			this.skuBarcode = skuBarcode;
		}
		public Integer getSkuCost() {
			return skuCost;
		}
		public void setSkuCost(Integer skuCost) {
			this.skuCost = skuCost;
		}
	
}
