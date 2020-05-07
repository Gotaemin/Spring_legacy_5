package com.tm.s5.notice;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
	public int boardWrite(BoardVO boardVO, MultipartFile[] files) throws Exception {
		String path = servletContext.getRealPath("/resources/upload/notice");
		System.out.println(path);

		boardVO.setNum(noticeDAO.boardNum());


		int result = noticeDAO.boardWrite(boardVO);

		for (MultipartFile file : files) {

			if (file.getSize() > 0) {
				BoardFileVO boardFileVO = new BoardFileVO();

				String fileName = fileSaver.saveByUtils(file, path);

				boardFileVO.setNum(boardVO.getNum());
				boardFileVO.setFileName(fileName);
				boardFileVO.setOriName(file.getOriginalFilename());
				boardFileVO.setBoard(1);

				result = boardFileDAO.fileInsert(boardFileVO);
				
				
				if(result < 1) {
					throw new Exception();
				}
			}

//			System.out.println(fileName);
		}

		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO, MultipartFile[] files) throws Exception {
		String path = servletContext.getRealPath("/resources/upload/notice");
		System.out.println("path : " + path);

		int result = noticeDAO.boardUpdate(boardVO);
		for (MultipartFile file : files) {
			String fileName = fileSaver.saveByUtils(file, path);

			System.out.println("fileName: " + fileName);

			BoardFileVO boardFileVO = new BoardFileVO();
			boardFileVO.setNum(boardVO.getNum());
			boardFileVO.setOriName(file.getOriginalFilename());
			boardFileVO.setFileName(fileName);
			boardFileVO.setBoard(1);

			result = boardFileDAO.fileInsert(boardFileVO);
		}
		// System.out.println("return result = "+result);
		return result;
	}

	@Override
	public int boardDelete(long num) throws Exception {
		String path = servletContext.getRealPath("/resources/upload/notice");

		List<BoardFileVO> list = boardFileDAO.fileList(num);
		int result = 0;
		for (BoardFileVO boardFileVO : list) {
			// HDD에서 파일삭제
			String fileName = boardFileVO.getFileName();
			result = fileSaver.deleteFile(fileName, path);

		}
		// DB에서 데이터삭제
		result = boardFileDAO.fileDeletes(num);
		
		result = noticeDAO.boardDelete(num);

		return result;
	}

}
