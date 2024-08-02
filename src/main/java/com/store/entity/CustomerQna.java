package com.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
public class CustomerQna {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="qna_idx")
	int qnaIdx;
	
	@Column(name="faqtype_idx")
	int faqtypeIdx;
	
	@Column(name="customer_idx")
	int customerIdx;
	
	@Column(nullable=false, name="qna_title")
	String qnaTitle;
	
	@Column(nullable=false, name="qna_text")
	String qnaText;
	
	@Column(name="qna_date")
	String qnaDate;
	
}
