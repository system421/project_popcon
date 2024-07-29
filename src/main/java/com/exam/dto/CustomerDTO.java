package com.exam.dto;

import java.util.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	
	int customerIdx;
	String customerId;
	String customerPw;
	String customerName;
	String customerPhone;
	Date customerDate;
	String customerAdd;
	String customerAddMore;
	String customerEmail;
	String customerRate;
	String customerRole;
	
}
