package com.tm.s5.board.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardFileService {

	@Autowired
	private BoardFileDAO boardFileDAO;
	
	public int fileDelete(Long fnum) throws Exception{
		return boardFileDAO.fileDelete(fnum);
	}
	
	public BoardFileVO fileSelect(BoardFileVO boardFileVO) throws Exception{
		return boardFileDAO.fileSelect(boardFileVO);
	}
	
}
