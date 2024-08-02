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
	
		@Override
		public List<FaqDTO> findAllFaq() {
//			List<FaqDTO> faqList=faqMapper.findAllFaq();
//			System.out.println("FaqServiceImpl : " + faqMapper);
			return faqMapper.findAllFaq();
		}

}
