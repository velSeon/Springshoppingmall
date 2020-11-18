package com.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.GoodsService;
import com.service.MemberService;

@Controller
public class GoodsController {
	
	@Autowired
	GoodsService service;
	
	@RequestMapping("/loginCheck/cartDelete")
	@ResponseBody
	public void cartDelete(@RequestParam("num") int num) {

		service.cartDelete(num);
	}
	
	@RequestMapping("/loginCheck/cartUpdate")
	@ResponseBody
	public void cartUpdate(@RequestParam Map<String,String> map) {
System.out.println(map);
		service.cartUpdate(map);
	}
	
	
	@RequestMapping("/loginCheck/cartList")
	public String cartList(RedirectAttributes attr,  HttpSession session) {
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String userid = dto.getUserid();
		List<CartDTO> list = service.cartList(userid);
		attr.addFlashAttribute("cartList", list);
		return "redirect:../cartList";
	}
	
	
	@RequestMapping("/loginCheck/cartAdd")
	public String cartAdd(CartDTO cart, HttpSession session) {
		MemberDTO mDTO = (MemberDTO)session.getAttribute("login");
		cart.setUserid(mDTO.getUserid());
		service.cartAdd(cart);
		return "redirect:../goodsRetrieve?gCode="+cart.getgCode();
	}
	
	
	
	
	
	
	@RequestMapping("/goodsRetrieve")  //goodsRetrieve.jsp
	@ModelAttribute("goodsRetrieve")
	public GoodsDTO goodsRetrieve(@RequestParam("gCode") String gCode) {
		GoodsDTO dto = service.goodsRetrieve(gCode);
		return dto;
	}
	@RequestMapping("/goodsList")
	public ModelAndView goodsList(@RequestParam("gCategory") String gCategory) {
		List<GoodsDTO> list = service.goodsList(gCategory);
		ModelAndView mav = new ModelAndView();
		mav.addObject("goodsList", list);
		//request.setAttribute("goodsList", list); 동일
		mav.setViewName("main"); //goodsList.jsp
		return mav;
	}
	@RequestMapping("/goodsList/gCategory/{category}")
	public String goodsList2(@PathVariable("category")String gCategory,
			Model m) {
		List<GoodsDTO> list = service.goodsList(gCategory);
		m.addAttribute("goodsList", list);
		return "redirect:../../goodsList?gCategory="+gCategory;
	}
	
}
