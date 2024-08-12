package com.store.dto;

import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.ibatis.type.Alias;

import com.store.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CustomerDTO {
	
	
	  private int customerIdx;
	    private String customerId;
	    private String customerPw;
	    private String customerName;
	    private String customerPhone;
	    private Date customerDate;
	    private int customerGender;
	    private Timestamp customerTime;
	    private String customerAdd;
	    private String customerAddMore;
	    private String customerEmail;
	    private String customerRate;
	    private String customerRole;
	    private int cartIdx;
	    public CustomerDTO(Customer customer) {
	        this.customerIdx = customer.getCustomerIdx();
	        this.customerId = customer.getCustomerId();
	        this.customerPw = customer.getCustomerPw();
	        this.customerName = customer.getCustomerName();
	        this.customerPhone = customer.getCustomerPhone();
	        this.customerDate = customer.getCustomerDate();
	        this.customerGender = customer.getCustomerGender();
	        this.customerTime = customer.getCustomerTime();
	        this.customerAdd = customer.getCustomerAdd();
	        this.customerAddMore = customer.getCustomerAddMore();
	        this.customerEmail = customer.getCustomerEmail();
	        this.customerRate = customer.getCustomerRate();
	        this.customerRole = customer.getCustomerRole();
	        this.cartIdx = customer.getCart().getCartIdx();
	    }
	
}
