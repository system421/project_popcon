package com.store.entity;


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

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class Wish {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wish_idx")
    private int wishIdx;

    @ManyToOne
    @JoinColumn(name = "customer_idx", referencedColumnName = "customer_idx", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "sku_idx", referencedColumnName = "sku_idx", nullable = false)
    private Sku sku;
}