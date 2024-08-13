package com.store.entity;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Entity
public class Customer {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "customer_idx")
	    private int customerIdx;

	    @Column(name = "customer_id")
	    private String customerId;

	    @Column(name = "customer_pw")
	    private String customerPw;

	    @Column(name = "customer_name")
	    private String customerName;

	    @Column(name = "customer_phone")
	    private String customerPhone;

	    @Column(name = "customer_date")
	    private Date customerDate;

	    @Column(name = "customer_gender")
	    private int customerGender;

	    @Column(name = "customer_time")
	    private Timestamp customerTime;

	    @Column(name = "customer_add")
	    private String customerAdd;

	    @Column(name = "customer_add_more")
	    private String customerAddMore;

	    @Column(name = "customer_email")
	    private String customerEmail;

	    @Column(name = "customer_rate")
	    private String customerRate;

	    @Column(name = "customer_role")
	    private String customerRole;

	    @OneToOne(mappedBy = "customer")
	    @JsonManagedReference
	    private CartEntity cart;
	}