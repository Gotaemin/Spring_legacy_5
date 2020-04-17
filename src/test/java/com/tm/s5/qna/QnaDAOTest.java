package com.tm.s5.qna;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tm.s5.AbstractTestCase;

public class QnaDAOTest extends AbstractTestCase {

	@Autowired
	private QnaDAO qnaDAO;
	
	
	@Test
	public void qnaWrite() throws Exception {
		QnaVO qnaVO = new QnaVO();
		qnaVO.setTitle("title");
		qnaVO.setContents("contents");
		qnaVO.setWriter("writer");
		
		qnaDAO.boardWrite(qnaVO);
	}

}
