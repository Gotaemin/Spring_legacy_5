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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tm.s5.member.MemberVO;
import com.tm.s5.member.memberFile.MemberFileVO;
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
	
	@RequestMapping(value = "fileDelete")
	public String fileDelete(String id,HttpSession session) throws Exception{
		System.out.println("fileDelete");
		
		int result = userService.fileDelete(id,session);
		
		return "redirect:./userPage";
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
	public ModelAndView memberJoin(MemberVO memberVO, MultipartFile avatar,HttpSession session, ModelAndView mv) throws Exception {

		int result = userService.memberJoin(memberVO,avatar,session);
		
		String msg ="Member Join Fail";
		if(result>0) {
			msg = "Member Join Success";
		}
		
		mv.addObject("result", msg);
		mv.addObject("path", "../");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	//Page
	@RequestMapping(value= "userPage")
	public String memberPage(HttpSession session,Model model) throws Exception {
		
		MemberVO memberVO =  (MemberVO)session.getAttribute("memberVO");

		MemberFileVO memberFileVO = userService.fileSelect(memberVO.getId());
		model.addAttribute("file", memberFileVO);
		
		return "member/memberPage";
	}
	
	//delete
	
	//update
	@RequestMapping(value= "userUpdate")
	public String memberUpdate() {
		return "member/memberUpdate";
	}
	@RequestMapping(value= "memberUpdate", method = RequestMethod.POST)
	public ModelAndView memberUpdate(ModelAndView mv, MemberVO memberVO, HttpSession session) throws Exception {
		String id = ((MemberVO)session.getAttribute("memberVO")).getId();
		memberVO.setId(id);
		
		int result = userService.memberUpdate(memberVO);
		
		if(result>0) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:./memberPage");
		}else {
			 mv.addObject("result", "Update Fail");
			 mv.addObject("path", "./memberPage");
			 mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	
}
