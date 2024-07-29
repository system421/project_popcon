package com.exam.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.exam.dto.Member;

public interface MemberService {
	List<Member> findById();
}
