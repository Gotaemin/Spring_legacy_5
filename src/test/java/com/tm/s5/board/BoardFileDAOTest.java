package com.tm.s5.board;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tm.s5.AbstractTestCase;
import com.tm.s5.board.file.BoardFileDAO;
import com.tm.s5.board.file.BoardFileVO;

public class BoardFileDAOTest extends AbstractTestCase{

	@Autowired
	private BoardFileDAO boardFileDAO;
	
	@Test
	public void boardFileInsertTest() throws Exception {

		BoardFileVO boardFileVO = new BoardFileVO();
		boardFileVO.setNum(2);
		boardFileVO.setFileName("testinsert");
		boardFileVO.setOriName("testori");
		boardFileVO.setBoard(1);
		
		int result = boardFileDAO.fileInsert(boardFileVO);
		
		assertNotEquals(0, result);
				
	}

}
