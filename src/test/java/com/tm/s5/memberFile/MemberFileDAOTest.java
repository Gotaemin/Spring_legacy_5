package com.tm.s5.memberFile;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tm.s5.AbstractTestCase;
import com.tm.s5.member.memberFile.MemberFileVO;
import com.tm.s5.member.memberFile.MemberFileDAO;

public class MemberFileDAOTest extends AbstractTestCase{

	@Autowired
	private MemberFileDAO memberFileDAO;
	
	@Test
	public void fileInsertTest() throws Exception{
		MemberFileVO fileVO = new MemberFileVO();
		fileVO.setId("user0");
		fileVO.setFileName("test");
		fileVO.setOriName("oriTest");
		
		int result = memberFileDAO.fileInsert(fileVO);
		
		assertNotEquals(0, result);
		
	}

}
