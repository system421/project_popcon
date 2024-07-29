package com.exam.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.Member;
import com.exam.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
	@GetMapping("/MyPage")
    public List<Member> listMembers() {
		List<Member> list = memberService.findById();
		System.out.println(memberService.findById());
        return list;
        
    }

}













