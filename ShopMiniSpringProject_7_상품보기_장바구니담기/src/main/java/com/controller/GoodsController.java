package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	GoodsService serivce;
	
	@RequestMapping("/loginCheck/cartAdd")
	public String cartAdd(CartDTO cart, HttpSession session) {//파싱
		MemberDTO mDTO= (MemberDTO)session.getAttribute("login");//세션에서 회원정보얻기
		cart.setUserid(mDTO.getUserid());//회원정보에서 id를  꺼내 cartDto에 넣어주기 
		session.setAttribute("mesg", cart.getgCode());
		serivce.cartAdd(cart);//db insert 
		return "redirect:../goodsRetrieve?gCode="+cart.getgCode(); //리다이렉션	
	}
	@RequestMapping("/goodsRetrieve") //페이지는 goodsRetrieve.jsp
	@ModelAttribute("goodsRetrieve")   //goodsRetrieve가 키가 됨 
	public GoodsDTO goodsRetrieve(@RequestParam("gCode") String gCode) {//리턴타입 주의  
		GoodsDTO dto= serivce.goodsRetrieve(gCode);
		return dto;		//request.setAttribute("goodsRetrive", dto);
	}
	
	
	
	
	
	
	
	
	
	//goodsRetrieve.jsp	
	//key값
	@RequestMapping("/goodsList")
	public ModelAndView goodsList(@RequestParam("gCategory") String gCategory) {
		if(gCategory== null) {
			gCategory="top";
		}
		List<GoodsDTO> list= serivce.goodsList(gCategory);
		ModelAndView mav= new ModelAndView();
		mav.addObject("goodsList", list);
		//request.setAttribute("goodsList", list)와 동일
		mav.setViewName("main"); //main.jsp
		return mav;				
	}
	/*
	 * @RequestMapping("/goodsList/gCategory/{category}") public String
	 * goodsList2(@PathVariable("category") String gCategory, Model m) {
	 * List<GoodsDTO> list =serivce.goodsList(gCategory);
	 * m.addAttribute("goodsList", list); return
	 * "redirect:../../goodsList?gCategory="+gCategory; }
	 */
	
}
