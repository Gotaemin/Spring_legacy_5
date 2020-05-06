package com.tm.s5.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//request.dispatcher  //response.redirect
		
		System.out.println("컨트롤러 진입 전");
		System.out.println("리턴이 참이면 컨트롤러로 전송/ 리턴이 거짓이면 컨트롤러로 이동이 안됨");
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		System.out.println("컨트롤러 빠져나올 때");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)	throws Exception {
		System.out.println("jsp 렌더링 종료 후");
		
	}
}
