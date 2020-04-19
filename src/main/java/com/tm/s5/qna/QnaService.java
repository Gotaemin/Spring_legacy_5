package com.tm.s5.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.s5.board.BoardService;
import com.tm.s5.board.BoardVO;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public List<BoardVO> boardList(int curPage) throws Exception {
		int starRow = (curPage-1)*10+1;
		int lastRow = curPage * 10;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", starRow);
		map.put("lastRow", lastRow);
		
		
		return qnaDAO.boardList(map);
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
	public int boardWrite(BoardVO boardVO) throws Exception {
		return qnaDAO.boardWrite(boardVO);
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
