package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.MemberDTO;
import com.service.MemberSerivce;

@Controller
public class MemberController {
	@Autowired
	MemberSerivce service;
	
	@RequestMapping(value = "/memberAdd")
	public String memberAdd(MemberDTO m,Model model) {
		service.memberAdd(m);
		model.addAttribute("success", "회원가입성공");
		return "main";
	}
}
