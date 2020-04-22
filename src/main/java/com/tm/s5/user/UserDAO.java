package com.tm.s5.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tm.s5.member.MemberDAO;
import com.tm.s5.member.MemberVO;
import com.tm.s5.util.Pager;

@Repository
public class UserDAO implements MemberDAO {

	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.tm.s5.user.UserDAO.";
	
	public int memberUpdate(MemberVO memberVO) throws Exception{
		return sqlSession.update(NAMESPACE+"memberUpdate", memberVO);
	}
	
	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberVO);
	}
	
	@Override
	public List<MemberVO> memberList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"memberList",pager);
	}
	
	@Override
	public long memberCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberCount", pager);
	}
	
	@Override
	public int memberJoin(MemberVO memberVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"memberJoin", memberVO);
	}

}
