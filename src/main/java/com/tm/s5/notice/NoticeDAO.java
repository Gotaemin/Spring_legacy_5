package com.tm.s5.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tm.s5.board.BoardDAO;
import com.tm.s5.board.BoardVO;
import com.tm.s5.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlsession;
	private final String NAMESPACE = "com.tm.s5.notice.NoticeDAO.";

	public long boardNum() throws Exception{
		return sqlsession.selectOne(NAMESPACE+"boardNum");
	}
	
	
	@Override
	public long boardCount(Pager pager) throws Exception {
		return sqlsession.selectOne(NAMESPACE+"boardCount",pager);
	}
	
	@Override
	public int boardDelete(long num) throws Exception {
		return sqlsession.delete(NAMESPACE+"boardDelete", num);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return sqlsession.update(NAMESPACE+"boardUpdate", boardVO);
	}

	@Override
	public int hitUpdate(long num) throws Exception {
		return sqlsession.update(NAMESPACE+"hitUpdate", num);
	}

	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		return sqlsession.selectList(NAMESPACE+"boardList",pager);
	}
	
	@Override
	public BoardVO boardSelect(long num) throws Exception {
		return sqlsession.selectOne(NAMESPACE+"boardSelect", num);
	}
	
	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return sqlsession.insert(NAMESPACE+"boardWrite", boardVO);
	}

}
