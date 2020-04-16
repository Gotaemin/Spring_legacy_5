package com.tm.s5.board;

import java.util.List;

public interface BoardDAO {
	//List
	public List<BoardVO> boardList() throws Exception;
	
	//Select
	public BoardVO boardSelect() throws Exception;
	
	//insert
	public int boardWrite(BoardVO boardVO) throws Exception;
	
	//delete
	public int boardDelete(long num) throws Exception;
	
	//update 
	public int boardUpdate(BoardVO boardVO) throws Exception;
	
	//hit update
	public int hitUpdate(BoardVO boardVO) throws Exception;
	
}
