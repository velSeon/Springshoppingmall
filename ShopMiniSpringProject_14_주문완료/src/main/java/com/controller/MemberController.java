package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/idDuplicateCheck", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String idDuplicatedCheck(@RequestParam("id") String userid) {
		MemberDTO dto= service.myPage(userid);
		System.out.println("idDuplicatedCheck====   "+ userid);
		String mesg="아이디 사용가능";
		if(dto != null) {
			mesg="아이디 중복";
		}
		return mesg;
	}

	@RequestMapping(value = "/loginCheck/memberUpdate")
	public String memberUpdate(MemberDTO m) {
		System.out.println("memberUpdate====="+ m);
		service.memberUpdate(m);
		return "redirect:../loignCheck/myPage";
	}
	@RequestMapping(value = "/loignCheck/myPage")
	public String myPage(HttpSession session) {
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String userid= dto.getUserid();
		dto= service.myPage(userid);
		session.setAttribute("login", dto);
		System.out.println("mypage함수 호출 =======");
		return "redirect:../myPage"; //servlet-context에등록		
	}
	@RequestMapping(value = "/memberAdd")
	public String memberAdd(MemberDTO m,Model model) {
		service.memberAdd(m);
		model.addAttribute("success", "회원가입성공");
		return "main";
	}
}
