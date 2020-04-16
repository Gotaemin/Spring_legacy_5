package com.tm.s5.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tm.s5.AbstractTestCase;

public class NoticeDAOTest extends AbstractTestCase{

	@Autowired
	private NoticeDAO noticeDAO;
	
	
	@Test
	public void daoIsNull() {
		assertNotNull(noticeDAO);
	}
	
	@Test
	public void boardWriteTest() throws Exception{
		
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("test Title");
		noticeVO.setWriter("test Writer");
		noticeVO.setContents("test Contents");
		
		int result = noticeDAO.boardWrite(noticeVO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void boardUpdate() throws Exception{
		
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("new title");
		noticeVO.setWriter("new Writer");
		noticeVO.setContents("new Contents");
		noticeVO.setNum(2);
		
		int result = noticeDAO.boardUpdate(noticeVO);
		
		assertEquals(1, result);
		
	}
	
	@Test
	public void hitUpdate() throws Exception{
		
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(3);

		int result = noticeDAO.hitUpdate(noticeVO);
		assertEquals(1, result);
		
	}
	
//	@Test
//	public void boardDelete() throws Exception{
//		int result = noticeDAO.boardDelete(1);
//		
//		assertNotEquals(0, result);
//	}

}




















