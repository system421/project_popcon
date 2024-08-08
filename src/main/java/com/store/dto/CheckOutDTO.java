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
@Alias("CheckOutDTO")
public class CheckOutDTO {

	private int cartIdx;			  //카트고유번호
	private int customerIdx;		  //유저고유번호
	private int skuIdx;			  //제품번호
	private String skuName;		  //제품이름
	private int skuValue;            //제품수량
	private int skuCost;			  //제품가격
	private String customerName;     //유저이름
	private String customerPhone;    //폰넘버
	private String customerEmail;    //이메일
	private String customerAdd;      //주소
	private String customerAddMore; //상세주소
	private int sumCost;			  //각 제품의 수량*가격
	private int totalSumCost;		  //총 가격
	
	
	
}
