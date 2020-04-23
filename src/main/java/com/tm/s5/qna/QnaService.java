package com.tm.s5.qna;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tm.s5.board.BoardService;
import com.tm.s5.board.BoardVO;
import com.tm.s5.board.file.BoardFileDAO;
import com.tm.s5.board.file.BoardFileVO;
import com.tm.s5.util.FileSaver;
import com.tm.s5.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private BoardFileDAO boardFileDAO;
	
	@Autowired
	private FileSaver fileSaver;
	
	@Autowired
	private ServletContext servletContext;
	
	
	
	public int boardReply(BoardVO boardVO) throws Exception{
		int result = qnaDAO.boardReplyUpdate(boardVO);
		result = qnaDAO.boardReply(boardVO);
		
		return result;
	}
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		
		pager.setSearch("");
		pager.makeRow();
		
		long totalCount = qnaDAO.boardCount(pager);
		pager.makePage(totalCount);
		
		return qnaDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		System.out.println("servie insert");
		qnaDAO.hitUpdate(num);
		
		BoardVO boardVO = qnaDAO.boardSelect(num);
		System.out.println("servie out");
		return boardVO;
	}

	@Override
	public int boardWrite(BoardVO boardVO,MultipartFile[] files) throws Exception {
		
		String path = servletContext.getRealPath("resources/Upload/qna");
		System.out.println(path);
		
		int result = qnaDAO.boardWrite(boardVO);
		
		for (MultipartFile file : files) {
			String fileName = fileSaver.saveByUtils(file, path);
			
			BoardFileVO boardFileVO = new BoardFileVO();
			boardFileVO.setNum(boardVO.getNum());
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(file.getOriginalFilename());
			boardFileVO.setBoard(2);
			
			result = boardFileDAO.fileInsert(boardFileVO);
			
		}
		return result;
	}

	@Override
	public int boardDelete(long num) throws Exception {
		return qnaDAO.boardDelete(num);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return qnaDAO.boardUpdate(boardVO);
	}

}
























