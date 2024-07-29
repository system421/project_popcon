package com.exam.service;

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
import com.exam.dto.Member;
import com.exam.mapper.MemberMapper;
import com.exam.service.MemberService;
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
