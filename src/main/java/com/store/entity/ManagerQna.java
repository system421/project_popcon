package com.store.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ManagerQna {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mqna_idx")
	int mqnaIdx;
	
	@Column(name="qna_ans")
	Boolean qnaAns;
	
	@Column(name="qna_clear_date")
	String qnaClearDate;
	
//	@OneToOne
//	@JoinColumn(name="qna_idx") // CustomerQna의 기본 키와 연결
//	private CustomerQna customerQna;

}
