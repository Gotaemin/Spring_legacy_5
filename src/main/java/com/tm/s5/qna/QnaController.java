package com.tm.s5.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	//select(GET)
	@RequestMapping(value = "qnaSelect")
	public void boardSelect() throws Exception{
		
	}
	
	//list(GET)
	@RequestMapping(value = "qnaList")
	public void boardList() throws Exception{
		
	}
	
	//update(GET/POST)
	@RequestMapping(value = "qnaUpdate")
	public void boardUpdate() throws Exception{
		
	}
	@RequestMapping(value = "qnaUpdate",method = RequestMethod.POST)
	public void boardUpdate2() throws Exception{
		
	}
	
	
	//delete(GET)
	@RequestMapping(value = "qnaDelete")
	public void boardDelete() throws Exception{
		
	}
	
	//insert(GET/POST)
	@RequestMapping(value = "qnaWrite")
	public void boardWrite() throws Exception{
		
	}
	@RequestMapping(value = "qnaWrite",method = RequestMethod.POST)
	public void boardWrite2() throws Exception{
		
	}
	
	
}
