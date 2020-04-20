package com.tm.s5.member;

import java.util.List;

import com.tm.s5.board.page.Pager;

public interface MemberDAO {

	//login- selectOne
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;
	
	//List
	public List<MemberVO> memberList(Pager pager) throws Exception;
	
	//Count
	public long memberCount(Pager pager) throws Exception; 
	
	//insert
	public long memberJoin(MemberVO memberVO) throws Exception;
	
	//update
	
	//delete
	
	
	
	
}
