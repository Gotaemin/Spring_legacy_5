package com.tm.s5.boardFile;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tm.s5.AbstractTestCase;
import com.tm.s5.board.file.BoardFileDAO;
import com.tm.s5.board.file.BoardFileVO;

public class BoardFileDAOTest extends AbstractTestCase{

	@Autowired
	private BoardFileDAO boardFileDAO;
	
	@Test
	public void fileListTest() throws Exception {
		List<BoardFileVO> fileList =  boardFileDAO.fileList(269L);
		assertNotNull(fileList);
	}

}
