package com.tm.s5.board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
	
	
	
	//count 
	public long boardCount() throws Exception;
	
	//List
	public List<BoardVO> boardList(Map<String, Integer> map) throws Exception;
	
	//Select One
	public BoardVO boardSelect(long num) throws Exception;
	
	//insert
	public int boardWrite(BoardVO boardVO) throws Exception;
	
	//delete
	public int boardDelete(long num) throws Exception;
	
	//update 
	public int boardUpdate(BoardVO boardVO) throws Exception;
	
	//hit update
	public int hitUpdate(long num) throws Exception;
	
}
