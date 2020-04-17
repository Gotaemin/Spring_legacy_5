package com.tm.s5.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tm.s5.AbstractTestCase;
import com.tm.s5.board.BoardVO;

public class NoticeDAOTest extends AbstractTestCase{

	@Autowired
	private NoticeDAO noticeDAO;
	
	
//	@Test
	public void daoIsNull() {
		assertNotNull(noticeDAO);
	}
	
//	@Test
	public void boardListTest(Map<String, Integer> map) throws Exception{
		List<BoardVO> ar =  noticeDAO.boardList(map);
		assertNotEquals(0, ar.size());
	}
	
//	@Test
	public void boardSelect() throws Exception{
		
		BoardVO boardVO = noticeDAO.boardSelect(2);
		
		assertNotNull(boardVO);
	}
	
	@Test
	public void boardWriteTest() throws Exception{
		int result = 0;
		
		String writer = "";
		String title = "";
		String contents="";
		
		for (int i = 0; i < 150; i++) {
			NoticeVO noticeVO = new NoticeVO();
			
			if(i%3==0) {
				writer="iu";
				title="testIU";
				contents = "contentsIU";
			}else if(i%3==1){
				writer ="choa";
				title = "titleCHOA";
				contents = "contentsCHOA";
			}else {
				writer = "suji";
				title = "titleSUJI";
				contents = "contentsSUJI";
			}
			
			noticeVO.setTitle(title+"i");
			noticeVO.setWriter(writer);
			noticeVO.setContents(contents);
			
			result = noticeDAO.boardWrite(noticeVO);
			
			if(i == 50 || i == 100) {
				Thread.sleep(1000);
			}
			
		}
	}
	
//	@Test
	public void boardUpdate() throws Exception{
		
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("new title");
		noticeVO.setWriter("new Writer");
		noticeVO.setContents("new Contents");
		noticeVO.setNum(2);
		
		int result = noticeDAO.boardUpdate(noticeVO);
		
		assertEquals(1, result);
		
	}
	
//	@Test
	public void hitUpdate() throws Exception{
		int result = noticeDAO.hitUpdate(2);
		assertNotEquals(0, result);
		
	}
	
//	@Test
//	public void boardDelete() throws Exception{
//		int result = noticeDAO.boardDelete(1);
//		
//		assertNotEquals(0, result);
//	}

}




















