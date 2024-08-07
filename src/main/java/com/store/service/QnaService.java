package com.store.service;

import java.util.List;

import com.store.dto.QnaDTO;
import com.store.entity.CustomerQna;

public interface QnaService {
	// 문의내역 등록
	CustomerQna PostMyQna(CustomerQna qna);
	// 문의내역 조회
	public List<QnaDTO> findMyQna();
}
