package com.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.store.dto.QnaDTO;

@Mapper
public interface QnaMapper {
	public List<QnaDTO> findMyQna(int CustomerIdx);
}
