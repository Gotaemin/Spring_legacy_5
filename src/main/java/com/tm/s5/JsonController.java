package com.tm.s5;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tm.s5.board.BoardVO;
import com.tm.s5.notice.NoticeService;
import com.tm.s5.util.Pager;

@RestController
@RequestMapping("json")
public class JsonController {
	
	@Autowired
	private NoticeService noticeService;
	
	
	@GetMapping("json1")
	@ResponseBody
	public List<BoardVO> json1(Pager pager) throws Exception{
		
		BoardVO boardVO = noticeService.boardSelect(30);
		List<BoardVO> list = noticeService.boardList(pager);
		
		
		return list;
	}
	
}
