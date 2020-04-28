package com.tm.s5.board.file;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.s5.util.FileSaver;

@Service
public class BoardFileService {

	@Autowired
	private BoardFileDAO boardFileDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileSaver fileSaver;	
	
	
	public int fileDelete(BoardFileVO boardFileVO) throws Exception{
		boardFileVO = boardFileDAO.fileSelect(boardFileVO);
		int result = boardFileDAO.fileDelete(boardFileVO);
		
		String board = "upload/notice";
		if(boardFileVO.getBoard() == 2) {
			board = "upload/qna";
		}
		String path = servletContext.getRealPath("/resources/"+board);

		//HDD삭제
		result = fileSaver.deleteFile(boardFileVO.getFileName(), path);
		
		
		//DB삭제
		
		
		
		
		return result;
	}
	
	public BoardFileVO fileSelect(BoardFileVO boardFileVO) throws Exception{
		return boardFileDAO.fileSelect(boardFileVO);
	}
	
}
