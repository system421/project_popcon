package com.exam.mapper;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.exam.dto.Sku;

@Mapper
public interface SkuMapper {
//	 Member findByUserIdAndPassword(Map<String, String> params);
//	Member findByUsername(String userid);
//	int insertMember(Member member);
//	Member registerNewMember(@Valid Member member);
//	@Select("SELECT * FROM member")
    List<Sku> findAll();
    List<Sku> findByType(@Param("skutypeIdx") int skutypeIdx);
}

