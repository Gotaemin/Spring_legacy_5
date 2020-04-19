package com.tm.s5.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.s5.board.BoardService;
import com.tm.s5.board.BoardVO;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<BoardVO> boardList(int curPage) throws Exception {
		int starRow = (curPage-1)*10+1;
		int lastRow = curPage * 10;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", starRow);
		map.put("lastRow", lastRow);
		
		//총글의 개수
//		long totalCount = noticeDAO.boardCount();
//		System.out.println(totalCount);
//		
//		//총페이지의 개수
//		long totalPage = totalCount/10;
//		if(totalCount % 10 != 0) {
//			totalPage++;
//		}
//		System.out.println(totalPage);
		
		return noticeDAO.boardList(map);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		noticeDAO.hitUpdate(num);
		return noticeDAO.boardSelect(num);
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return noticeDAO.boardWrite(boardVO);
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
