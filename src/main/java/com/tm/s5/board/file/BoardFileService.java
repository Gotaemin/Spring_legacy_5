package com.tm.s5.board.file;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tm.s5.util.FileSaver;

@Service
public class BoardFileService {

	@Autowired
	private BoardFileDAO boardFileDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileSaver fileSaver;	
	
	
	public int summerDelete(String fileName) throws Exception{
		String path = servletContext.getRealPath("/resources/upload/summer");
		int result = fileSaver.deleteFile(fileName, path);
		
		return result;
	}
	
	
	public String fileInsert(MultipartFile files) throws Exception{
		String path = servletContext.getRealPath("/resources/upload/summer");
		System.out.println(path);
		
		String fileName = fileSaver.saveByUtils(files, path);
		path = servletContext.getContextPath()+"/resources/upload/summer/"+fileName;
		
		return path;
	}
	
	
	
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
