package com.store.service;

import java.util.List;

import com.store.dto.QnaDTO;
import com.store.entity.CustomerQna;

public interface QnaService {
	// 문의내용 등록
	CustomerQna PostMyQna(CustomerQna qna);
	// 문의내용 수정
	CustomerQna EditMyQna(int CustomerIdx, CustomerQna qna);
	// 문의내용 삭제
	CustomerQna DeleteMyQna(int CustomerIdx, CustomerQna qna);

	// 문의내역 조회
	public List<QnaDTO> findMyQna(int CustomerIdx);
}
