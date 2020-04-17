package com.tm.s5.qna;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tm.s5.board.BoardDAO;
import com.tm.s5.board.BoardVO;

@Repository
public class QnaDAO implements BoardDAO {

	@Autowired
	private SqlSession sqlsession;
	private final String NAMESPACE = "com.tm.s5.qna.QnaDAO.";
	
	
	@Override
	public long boardCount() throws Exception {
		return 0;
	}

	@Override
	public List<BoardVO> boardList(Map<String, Integer> map) throws Exception {
		return null;
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		return null;
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return sqlsession.insert(NAMESPACE+"qnaWrite", boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		return 0;
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return 0;
	}

	@Override
	public int hitUpdate(long num) throws Exception {
		return 0;
	}

}
