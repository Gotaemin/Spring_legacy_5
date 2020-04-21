package com.tm.s5.qna;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tm.s5.AbstractTestCase;
import com.tm.s5.board.BoardVO;
import com.tm.s5.util.Pager;

public class QnaDAOTest extends AbstractTestCase {

	@Autowired
	private QnaDAO qnaDAO;
	
	
//	@Test
	public void qnaWrite() throws Exception {
		QnaVO qnaVO = new QnaVO();
		qnaVO.setTitle("title");
		qnaVO.setContents("contents");
		qnaVO.setWriter("writer");
		
		qnaDAO.boardWrite(qnaVO);
	}
	
//	@Test
	public void qnaSelect() throws Exception{
		BoardVO boardVO = qnaDAO.boardSelect(2);
		
		assertNotNull(boardVO);
	}
	
	@Test
	public void qnaList() throws Exception{
		Pager pager = new Pager();
		
		System.out.println("search: "+pager.getSearch());
		assertNotNull(qnaDAO.boardList(pager));
		
	}
	
	

}
