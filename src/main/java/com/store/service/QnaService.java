package com.store.service;

import java.util.List;

import com.store.dto.QnaDTO;
import com.store.entity.CustomerQna;

public interface QnaService {
	CustomerQna PostMyQna(CustomerQna qna);
	public List<QnaDTO> findMyQna();
}
