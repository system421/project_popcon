package com.store.entity;


import java.math.BigDecimal;
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
@Table(name = "keep_item")
public class KeepItemEntity {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "keep_item_idx")
	    private int keepItemIdx;
	    
	    @ManyToOne
	    @JoinColumn(name = "fridge_idx", nullable = false)
	    @JsonBackReference
	    private Keep keep;
	    
	    @Column(name = "sku_idx", nullable = false)
	    private int skuIdx;
	    
	    @Column(name = "qty", nullable = false)
	    private int qty;
	}