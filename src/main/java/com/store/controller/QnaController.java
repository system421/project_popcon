package com.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
	public ResponseEntity<?> PostMyQna(@Valid @RequestBody CustomerQna qna,
												  BindingResult bindingResult) {
		
		// 유효성 검사 결과 확인
		if(bindingResult.hasErrors()) {
			// 오류가 있을 경우, 에러 메시지를 반환
			StringBuilder errorMessage = new StringBuilder("문의내역 확인 : ");
			bindingResult.getFieldErrors().forEach(error->
				errorMessage.append(error.getDefaultMessage()).append(""));
			return ResponseEntity.badRequest().body(errorMessage.toString());
		};
		//유효성 검사 통과시 DB 저장
		qna = qnaService.PostMyQna(qna);
		log.info("postMyQna qnaDTO : {}", qna); 
		return ResponseEntity.ok(qna);
	}
	
// 나의문의내역 조회
	@GetMapping("/myinquiry")
	public ResponseEntity<List<QnaDTO>> find(){
		
		//유저의 문의 내역 불러오기 
		List<QnaDTO> myQnaList = qnaService.findMyQna();
		return ResponseEntity.ok(myQnaList);
	}
}
