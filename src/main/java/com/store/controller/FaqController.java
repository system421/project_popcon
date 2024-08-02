package com.store.controller;

import java.util.ArrayList;
import java.util.List;

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
	
	@GetMapping("/faq")
	public List<FaqDTO> findAllFaq(){
		List<FaqDTO> faqlist = faqService.findAllFaq();
		log.info("faqlist : {}", faqlist); // faqlist 로그 출력
		if(faqlist==null) {
			log.info("faqlist==null : {} ", faqlist);
			System.out.println();
			return new ArrayList<>();
		}
		
		System.out.println("/faq 요청 : " + faqlist);
		return faqlist;
	}
}