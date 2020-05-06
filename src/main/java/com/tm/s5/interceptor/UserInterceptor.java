package com.tm.s5.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tm.s5.member.MemberVO;

public class UserInterceptor extends HandlerInterceptorAdapter{

	//memberPage요청시 로그인 유무 판단
	//로그인이 안 돼있으면 로그인 폼으로 이동
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		boolean check = false;
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("memberVO");
		
		if(memberVO != null) {
			check = true;
		}else {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("path", "./userLogin");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			dispatcher.forward(request, response);
		}
		
	
		return check;
	}
}
