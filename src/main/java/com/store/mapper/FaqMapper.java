package com.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.store.dto.FaqDTO;

@Mapper
public interface FaqMapper {
	//	자주묻는질문 Faq 조회
	public List<FaqDTO> findAllFaq();
	
}
