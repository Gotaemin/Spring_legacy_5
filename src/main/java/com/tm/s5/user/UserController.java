package com.tm.s5.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tm.s5.board.page.Pager;
import com.tm.s5.member.MemberVO;

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
	public String memberLogin() throws Exception{
		
		return "member/memberLogin";
	}
	@RequestMapping(value = "userLogin",method = RequestMethod.POST)
	public String memberLogin2(MemberVO memberVO,HttpSession session) throws Exception{
		
		System.out.println("controllerIn");
		memberVO = userService.memberLogin(memberVO);
		
		System.out.println(memberVO.getId()+" " +memberVO.getPwd());
		
		if(memberVO != null) {
			session.setAttribute("memberVO", memberVO);
		}		
		System.out.println("controller out");
		
		return "index";
	}
	
	//logout
	@RequestMapping(value = "userLogout")
	public String memberLogout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:./index";
	}
	
	
	// join - insert
	
	//delete
	
	//update
	
	
}
