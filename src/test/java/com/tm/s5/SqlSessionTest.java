package com.tm.s5;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SqlSessionTest extends AbstractTestCase{

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void sqlTest() throws Exception{
		
		assertNotNull(sqlSession);
		
	}
	
}
