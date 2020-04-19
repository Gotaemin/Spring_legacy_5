package com.tm.s5.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tm.s5.member.MemberDAO;
import com.tm.s5.member.MemberVO;

@Repository
public class UserDAO implements MemberDAO {

	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.tm.s5.user.UserDAO.";
	
	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberVO);
	}

}
