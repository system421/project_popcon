package com.store.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.store.dto.Member;

public interface MemberService {
	List<Member> findById();
}
