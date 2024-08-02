package com.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.store.dto.FaqDTO;

@Mapper
public interface FaqMapper {
	public List<FaqDTO> findAllFaq();
	
}
