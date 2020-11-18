package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.GoodsDTO;
import com.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	GoodsService serivce;
	
	@RequestMapping("/goodsList")
	public ModelAndView goodsList(@RequestParam("gCategory") String gCategory) {//상품목록보이기
		if(gCategory== null) {
			gCategory="top";//데이터가 없을 경우 기본값 설정 
		}
		List<GoodsDTO> list= serivce.goodsList(gCategory);
		ModelAndView mav= new ModelAndView();
		mav.addObject("goodsList", list);
		//request.setAttribute("goodsList", list)와 동일
		mav.setViewName("main"); //main.jsp
		return mav;				
	}
	
	
	
	@RequestMapping("/goodsList/gCategory/{category}")
	public String goodsList2() {
		return "";
	}
	
}
