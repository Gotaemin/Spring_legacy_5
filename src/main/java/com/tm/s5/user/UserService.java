package com.tm.s5.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.s5.member.MemberService;
import com.tm.s5.member.MemberVO;
import com.tm.s5.util.Pager;

@Service
public class UserService implements MemberService {

	@Autowired
	private UserDAO userDAO;
	
	
	public int memberJoin(MemberVO memberVO)throws Exception{
		return userDAO.memberJoin(memberVO);
	}
	
	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		return userDAO.memberLogin(memberVO);
	}

	@Override
	public List<MemberVO> memberList(Pager pager) throws Exception {
		
		pager.makeRow();
		
		long totalCount = userDAO.memberCount(pager);
		pager.makePage(totalCount);
		
		
		return userDAO.memberList(pager);
	}
	
	
	
}
