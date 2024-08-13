package com.store.dto;

import javax.validation.constraints.NotEmpty;

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
	
	@NotEmpty(message="제목을 입력하세요.")
	String qnaTitle;
	@NotEmpty(message="내용을 입력하세요.")
	String qnaText;
	String qnaDate;
	String qnaPicture;
	String qnaImage;
	
	
}