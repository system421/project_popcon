package com.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.dto.FaqDTO;
import com.store.mapper.FaqMapper;

@Service
public class FaqServiceImpl implements FaqService {

	FaqMapper faqMapper;
	
	public FaqServiceImpl(FaqMapper faqMapper) {
		this.faqMapper=faqMapper;
	}
	
	//	자주묻는질문 Faq 조회
	@Override
	public List<FaqDTO> findAllFaq() {
		return faqMapper.findAllFaq();
	}

}
