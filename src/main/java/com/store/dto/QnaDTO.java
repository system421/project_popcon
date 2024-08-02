package com.store.dto;

import org.apache.ibatis.type.Alias;

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
@Alias("QnaDTO")
public class QnaDTO {

	private int qnaIdx;
	private int faqtypeIdx;
	private int customerIdx;
	
	String qnaTitle;
	String qnaText;
	String qnaDate;
	
}
