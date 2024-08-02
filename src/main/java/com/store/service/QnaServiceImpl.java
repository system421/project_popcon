package com.store.service;

import org.springframework.stereotype.Service;

import com.store.entity.CustomerQna;
import com.store.repository.QnaRepository;

@Service
public class QnaServiceImpl implements QnaService {

	private QnaRepository qnaRepository;
	
	public QnaServiceImpl(QnaRepository qnaRepository) {
		this.qnaRepository = qnaRepository;
	}
	
	@Override
	public CustomerQna PostMyQna(CustomerQna qna) {
		return qnaRepository.save(qna);
	}

}
