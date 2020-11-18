package com.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	GoodsService serivce;
	
	@RequestMapping(value = "/loginCheck/cartUpdate")
	@ResponseBody
	public void cartUpdate(@RequestParam Map<String, String>map) { //한글설정필요없음
		System.out.println(map);
		serivce.cartUpdate(map);
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/loginCheck/cartList")
	public String cartList(RedirectAttributes attr, HttpSession session) {
		MemberDTO dto= (MemberDTO)session.getAttribute("login");
		String userid=dto.getUserid();
		List<CartDTO> list =serivce.cartList(userid);
		attr.addFlashAttribute("cartList", list);// 리다이렉트시 데이터 유지
		return "redirect:../cartList"; //servlet-context에 등록
		
	}
	@RequestMapping("/loginCheck/cartAdd")
	public String cartAdd(CartDTO cart, HttpSession session) {
		MemberDTO mDTO= (MemberDTO)session.getAttribute("login");
		cart.setUserid(mDTO.getUserid());
		session.setAttribute("mesg", cart.getgCode());
		serivce.cartAdd(cart);
		return "redirect:../goodsRetrieve?gCode="+cart.getgCode();
	}
	
	@RequestMapping("/goodsRetrieve")//goodsRetrieve.jsp
	@ModelAttribute("goodsRetrieve") //key값
	public GoodsDTO goodsRetrieve(@RequestParam("gCode") String gCode) {
		GoodsDTO dto= serivce.goodsRetrieve(gCode);
		return dto;		
	}
	
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
