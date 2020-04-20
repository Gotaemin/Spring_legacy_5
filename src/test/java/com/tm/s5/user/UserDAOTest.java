package com.tm.s5.user;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tm.s5.AbstractTestCase;
import com.tm.s5.member.MemberVO;


public class UserDAOTest extends AbstractTestCase{

	@Autowired
	private UserDAO userDAO;
	
//	@Test
	public void test() throws Exception{

		MemberVO memberVO = new MemberVO();
		memberVO.setId("admin");
		memberVO.setPwd("1234");
		memberVO = userDAO.memberLogin(memberVO);
		
		assertNotNull(memberVO);
	}
	
	@Test
	public void memberJoinTest() throws Exception{
		
		String id = "";
		String name = "";
		String phone = "";
		String email = "";
		
		for(int i=0; i<120;i++) {
			MemberVO memberVO = new MemberVO();
			
			id = "user"+i;
			
			if(i%3 == 0) {
				name ="iu";
				phone = "111";
				email = "iu@naver.com";
			}else if(i%3 == 1) {
				name ="choa";
				phone = "222";
				email = "choa@naver.com";
			}else if(i%3 == 2) {
				name ="suji";
				phone = "333";
				email = "sugi@naver.com";
			}
			
			
			memberVO.setId(id);
			memberVO.setPwd("1234");
			memberVO.setName(name);
			memberVO.setPhone(phone);
			memberVO.setEmail(email);
			
			long result = userDAO.memberJoin(memberVO);
			
			if(i == 50 || i == 100) {
				Thread.sleep(1000);
			}
			
		}
		
		
	}

}
