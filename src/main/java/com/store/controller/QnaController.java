package com.store.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.entity.CustomerQna;
import com.store.service.QnaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class QnaController {

	QnaService qnaService;
	public QnaController(QnaService qnaService) {
		this.qnaService = qnaService;
	}

//	문의 신청하기 
	@PostMapping("/ask")
	public ResponseEntity<CustomerQna> PostMyQna(@RequestBody CustomerQna qna) {
		qna = qnaService.PostMyQna(qna);
		log.info("postMyQna qnaDTO : {}", qna); 
		return ResponseEntity.ok(qna);
	}
}
