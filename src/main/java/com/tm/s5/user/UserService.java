package com.tm.s5.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.s5.member.MemberService;
import com.tm.s5.member.MemberVO;

@Service
public class UserService implements MemberService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		return userDAO.memberLogin(memberVO);
	}

}
