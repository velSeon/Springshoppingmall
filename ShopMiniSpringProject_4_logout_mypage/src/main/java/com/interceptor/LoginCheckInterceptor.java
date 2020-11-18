package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.plugin.InterceptorChain;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor  extends HandlerInterceptorAdapter{
@Override
//    /loginCheck/**  //장바구니, 마이페이지, 장바구니에서 삭제, 수량업데이트, 주문 등 회원전용 메뉴에서 선동작
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	System.out.println("preHandle동작     ================");
	HttpSession session = request.getSession();
	if(session.getAttribute("login") == null) {  //로그인 검사 (로그인시 세션에 넣어준 dto객체 존재여부)
		response.sendRedirect("../loginForm");//servlet-context.xml //로그인 페이지로 이동
		return false;  //주의  //이후 작업 진행 금지
	}else {
		return true; //주의 //로그인 정보가 있는 경우 이후 작업 계속 진행
	}
}
@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	//System.out.println("postHandle");
		
	}
@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	//System.out.println("afterCompletion");
	}

}
