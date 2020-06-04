package com.tm.s5.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tm.s5.board.BoardVO;
import com.tm.s5.member.MemberVO;

@Component
public class QnaInterceptor extends HandlerInterceptorAdapter{
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		boolean check = false;
		
		Object ob = request.getSession().getAttribute("memberVO");
		
		if(ob != null) {
			check = true;
		}else {
			response.sendRedirect("../user/userLogin");
		}
		
		return check;
	}
	
	
	
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView mv) throws Exception {
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("memberVO");
		
		BoardVO boardVO = (BoardVO)mv.getModel().get("boardVO");
		String board = (String)mv.getModel().get("board");
		board = board + "List";  //board+List
		
		
		String method = request.getMethod();
		String path = request.getServletPath();
		path = path.substring(path.lastIndexOf("/"));
		
		if(method.equals("GET") && path.equals("/qnaUpdate")) {
			if(memberVO != null) {
				if(!memberVO.getId().equals(boardVO.getWriter())) {
					mv.setViewName("redirect:./"+board);
				}
			}else {
				mv.addObject("msg", "권한이 필요합니다.");
				mv.addObject("path", "./"+board);
				mv.setViewName("common/result");
			}
		}
		
	}
}
