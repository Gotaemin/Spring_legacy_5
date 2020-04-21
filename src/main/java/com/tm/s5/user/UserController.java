package com.tm.s5.user;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tm.s5.member.MemberVO;
import com.tm.s5.util.Pager;

@Controller
@RequestMapping("/user/**")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@ModelAttribute("member")
	public String getMember() throws Exception{
		return "user";
	}
	
	//List
	@RequestMapping(value = "userList")
	public ModelAndView memberList(Pager pager,ModelAndView mv) throws Exception{
		List<MemberVO> memberList = userService.memberList(pager);
		
		mv.addObject("list", memberList);
		mv.addObject("pager", pager);
		mv.setViewName("member/memberList");
		
		return mv;
	}
	
	
	//login - select One
	@RequestMapping(value = "userLogin")
	public String memberLogin(@CookieValue(value = "cId",required = false)String cId,Model model) throws Exception{
		//System.out.println(cId);
		//model.addAttribute("cId", cId);
		return "member/memberLogin";
	}
	@RequestMapping(value = "userLogin",method = RequestMethod.POST)
	public String memberLogin2(MemberVO memberVO,HttpSession session,String remember,HttpServletResponse response) throws Exception{
		Cookie cookie = new Cookie("cId", "");
		
		if(remember != null) {
			cookie.setValue(memberVO.getId());
		}
		
		//cookie.setMaxAge(0);
		
		response.addCookie(cookie);
		
		memberVO = userService.memberLogin(memberVO);
		if(memberVO != null) {
			session.setAttribute("memberVO", memberVO);
		}else {
			return "member/memberLogin";
		}
		
		return "index";
	}
	
	//logout
	@RequestMapping(value = "userLogout")
	public String memberLogout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	// join - insert
	@RequestMapping("userJoin")
	public String memberJoin() throws Exception{
		return "member/memberJoin"; 
	}
	@RequestMapping(value= "userJoin", method = RequestMethod.POST)
	public ModelAndView memberJoin(MemberVO memberVO, String avatar, ModelAndView mv) throws Exception {
		System.out.println("avatar : "+avatar);
		int result = userService.memberJoin(memberVO);
		
		String msg ="Member Join Fail";
		if(result>0) {
			msg = "Member Join Success";
		}
		
		mv.addObject("result", msg);
		mv.addObject("path", "../");
		mv.setViewName("common/result");
		
		return mv;
	}
	//delete
	
	//update
	
	
}
