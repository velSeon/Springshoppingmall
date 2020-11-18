package com.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.MemberDTO;
import com.service.MemberSerivce;

@Controller
public class LoginController {
@Autowired
MemberSerivce service;

@RequestMapping(value = "/loginCheck/logout")
public String logout(HttpSession session) {
	session.invalidate();
	//return "../"; //.xml에 설정 main.jsp
	return "redirect:../"; //.xml에 설정 main.jsp ../ 을 이용하여 /loginCheck 의 상위 주소로 이동
	//하여 주소를 사용함
}




@RequestMapping(value = "/login")
public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) {
	MemberDTO dto = service.login(map);
	System.out.println(map);
	if(dto!= null ) {
		session.setAttribute("login", dto);  //로그인 정보 저장
		return "main";
	}else {
		model.addAttribute("mesg", "아이디 또는 비번이 잘못되었습니다.");
		return "loginForm";
	}
	
}
}
