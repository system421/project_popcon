package com.store.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.QnaDTO;
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
	
// 나의문의내역 조회
	@GetMapping("/myinquiry")
	public ResponseEntity<List<QnaDTO>> find(){
		List<QnaDTO> myQnaList = qnaService.findMyQna();
		return ResponseEntity.ok(myQnaList);
	}
}
