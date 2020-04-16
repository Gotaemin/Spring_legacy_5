package com.tm.s5.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tm.s5.board.BoardDAO;
import com.tm.s5.board.BoardVO;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlsession;
	private final String NAMESPACE = "com.tm.s5.notice.NoticeDAO.";

	@Override
	public int boardDelete(long num) throws Exception {
		return sqlsession.delete(NAMESPACE+"boardDelete", num);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return sqlsession.update(NAMESPACE+"boardUpdate", boardVO);
	}

	@Override
	public int hitUpdate(BoardVO boardVO) throws Exception {
		return sqlsession.update(NAMESPACE+"hitUpdate", boardVO);
	}

	@Override
	public List<BoardVO> boardList() throws Exception {
		return null;
	}
	
	@Override
	public BoardVO boardSelect() throws Exception {
		return null;
	}
	
	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return sqlsession.insert(NAMESPACE+"boardWrite", boardVO);
	}

}
