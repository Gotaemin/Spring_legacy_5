package com.tm.s5.user;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tm.s5.AbstractTestCase;
import com.tm.s5.member.MemberVO;


public class UserDAOTest extends AbstractTestCase{

	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void test() throws Exception{

		MemberVO memberVO = new MemberVO();
		memberVO.setId("admin");
		memberVO.setPwd("1234");
		memberVO = userDAO.memberLogin(memberVO);
		
		assertNotNull(memberVO);
		
	}

}
