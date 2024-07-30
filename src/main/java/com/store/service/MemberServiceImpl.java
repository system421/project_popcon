package com.store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.store.dto.Member;
import com.store.mapper.MemberMapper;
import com.store.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService{

	MemberMapper memberMapper;

	  @Autowired
	  public MemberServiceImpl(MemberMapper memberMapper) {
	        this.memberMapper = memberMapper;
	    }
	  @Override
	  public List<Member> findById() {
	        return memberMapper.findById();
	    }
	

	
}
