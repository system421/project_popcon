package com.store.entity;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class PayOrder {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "payorder_idx")
	    private int payOrderIdx;

	    @ManyToOne
	    @JoinColumn(name = "customer_idx", nullable = false)
	    private Customer customer;

	    @ManyToOne
	    @JoinColumn(name = "cart_idx", nullable = false)
	    private Cart cart;

	    @Column(name = "order_date", nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date orderDate;
	}