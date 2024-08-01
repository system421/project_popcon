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
@Alias("PayOrder")
public class PayOrderDTO {

	private int payOrderIdx;
    private int customerIdx;
    private int cartIdx;
    private Date orderDate;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAdd;
    private String customerAddMore;
    private int skuIdx;
    private int skuValue;
	public PayOrderDTO(int payOrderIdx, int customerIdx, int cartIdx, Date orderDate, String customerName,
			String customerEmail, String customerPhone, String customerAdd, String customerAddMore, int skuIdx,
			int skuValue) {
		super();
		this.payOrderIdx = payOrderIdx;
		this.customerIdx = customerIdx;
		this.cartIdx = cartIdx;
		this.orderDate = orderDate;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerAdd = customerAdd;
		this.customerAddMore = customerAddMore;
		this.skuIdx = skuIdx;
		this.skuValue = skuValue;
	}

	
}
