package com.store.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.FaqDTO;
import com.store.service.FaqService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FaqController {

	FaqService faqService;
	public FaqController(FaqService faqService) {
		this.faqService = faqService;
	}
	
	// 자주묻는질문 조회 기능
	@GetMapping("/faq")
	public ResponseEntity<List<FaqDTO>> findAllFaq(){
		
		List<FaqDTO> faqlist = faqService.findAllFaq();
		log.info("faqlist : {}", faqlist); // faqlist 로그 출력
		
		return ResponseEntity.ok(faqlist);
	}
}