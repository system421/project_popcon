package com.exam.entity;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	    @Column(nullable = false, unique = true, name = "customer_id")
	    private String customerId;

	    @Column(nullable = false, name = "customer_pw")
	    private String customerPw;

	    @Column(nullable = false, name = "customer_name") 
	    private String customerName;

	    @Column(nullable = false, name = "customer_phone")
	    private String customerPhone;

	    @Temporal(TemporalType.DATE)
	    @Column(name = "customer_date")
	    private Date customerDate;

	    @Column(name = "customer_add")
	    private String customerAdd;
	    
	    @Column(name = "customer_add_more")
	    private String customerAddMore;

	    @Column(nullable = false, unique = true, name = "customer_email")
	    private String customerEmail;

	    @Column(name = "customer_rate")
	    private String customerRate;
	    
	    @Column(name = "customer_role")
	    private String customerRole;

	   
	}