package com.tm.s5.board.file;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFileDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.tm.s5.board.file.BoardFileDAO.";
	
	public int fileDelete(BoardFileVO boardFileVO) throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDelete", boardFileVO);
	}
	
	public BoardFileVO fileSelect(BoardFileVO boardFileVO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"fileSelect", boardFileVO);
	}
	
	public int fileInsert(BoardFileVO boardFileVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"fileInsert", boardFileVO);
	}
	
	public List<BoardFileVO> fileList(Long num) throws Exception{
		return sqlSession.selectList(NAMESPACE+"fileList", num);
	}
	
	public int fileDeletes(Long num) throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDeletes", num);
	}
	
}
