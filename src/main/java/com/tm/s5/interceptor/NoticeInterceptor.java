package com.tm.s5.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tm.s5.member.MemberVO;

@Component
public class NoticeInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	throws Exception {
		boolean check = false;
	
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("memberVO");
		if(memberVO != null && memberVO.getId().equals("admin")) {
			check = true;
			System.out.println("관리자 O");
		}else {
			System.out.println("관리자 X");
//			response.sendRedirect("../user/userLogin");
			
			request.setAttribute("msg", "권한이 없습니다.");
			request.setAttribute("path", "../");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			dispatcher.forward(request, response);
		}
		
		return check;
	}
}
