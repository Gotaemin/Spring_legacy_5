package com.tm.s5.member;

import java.util.List;

import com.tm.s5.board.page.Pager;

public interface MemberService {
	// login- selectOne
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;

	// List
	public List<MemberVO> memberList(Pager pager) throws Exception;


	// insert

	// update

	// delete
}
