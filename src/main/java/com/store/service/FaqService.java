package com.store.service;

import java.util.List;

import com.store.dto.FaqDTO;

public interface FaqService {

	//	자주묻는질문 Faq 조회
	public List<FaqDTO>findAllFaq();
}
