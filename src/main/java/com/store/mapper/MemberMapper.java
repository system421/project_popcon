package com.store.mapper;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.store.dto.Member;

@Mapper
public interface MemberMapper {
//	 Member findByUserIdAndPassword(Map<String, String> params);
//	Member findByUsername(String userid);
//	int insertMember(Member member);
//	Member registerNewMember(@Valid Member member);
//	@Select("SELECT * FROM member")
    List<Member> findById();
}

