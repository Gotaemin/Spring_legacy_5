package com.tm.s5.memo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tm.s5.AbstractTestCase;

public class MemoDAOTest extends AbstractTestCase{

	@Autowired
	private MemoDAO memoDAO;
	
	@Test
	public void memoInsertTest() throws Exception {
		
		for(int i=0;i<100;i++) {
			MemoVO memoVO = new MemoVO();
			memoVO.setWriter("writer"+i);
			memoVO.setContents("contents"+i);
		
			memoDAO.memoInsert(memoVO);
			
			if(i==50) {
				Thread.sleep(1000);
			}
		}
		
		
	}

}
