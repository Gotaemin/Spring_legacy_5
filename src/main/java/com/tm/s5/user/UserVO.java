package com.tm.s5.user;

import com.tm.s5.member.MemberVO;
import com.tm.s5.member.memberFile.MemberFileVO;

public class UserVO extends MemberVO{

	private MemberFileVO memberFileVO;

	public MemberFileVO getMemberFileVO() {
		return memberFileVO;
	}

	public void setMemberFileVO(MemberFileVO memberFileVO) {
		this.memberFileVO = memberFileVO;
	}
	
}
