package com.tm.s5.notice;

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
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private BoardFileDAO boardFileDAO;
	
	@Autowired
	private FileSaver fileSaver;
	
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {

		pager.makeRow();
		
		long totalCount = noticeDAO.boardCount(pager);
		pager.makePage(totalCount);
		
		return noticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		noticeDAO.hitUpdate(num);
		return noticeDAO.boardSelect(num);
	}

	@Override
	public int boardWrite(BoardVO boardVO,MultipartFile[] files) throws Exception {
		String path = servletContext.getRealPath("/resources/Upload/notice");
		System.out.println(path);
		
		boardVO.setNum(noticeDAO.boardNum());
		
		System.out.println("getNum: "+boardVO.getNum()); //여기까지 됨
		
		int result = noticeDAO.boardWrite(boardVO);
		System.out.println("file len: "+files.length);
		
		for (MultipartFile file : files) {
			
			if(file.getSize()>0) {
				BoardFileVO boardFileVO = new BoardFileVO();
				
				System.out.println("file: "+file.getOriginalFilename());
				String fileName = fileSaver.saveByUtils(file, path);
				
				boardFileVO.setNum(boardVO.getNum());
				boardFileVO.setFileName(fileName);
				boardFileVO.setOriName(file.getOriginalFilename());
				System.out.println("oriName : "+ boardFileVO.getOriName());
				boardFileVO.setBoard(1);
				
				result= boardFileDAO.fileInsert(boardFileVO);
			}
			
//			System.out.println(fileName);
		}
		
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return noticeDAO.boardUpdate(boardVO);
	}
	
	@Override
	public int boardDelete(long num) throws Exception {
		return noticeDAO.boardDelete(num);
	}

}
