package com.store.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.store.dto.MemberDTO;

public interface MemberService {
	List<MemberDTO> findById();
}
