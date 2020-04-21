package com.tm.s5.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tm.s5.board.BoardVO;
import com.tm.s5.util.Pager;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@ModelAttribute("board")
	public String getBoard() throws Exception{
		return "notice";
	}
	
	
	@RequestMapping(value = "noticeDelete")
	public ModelAndView boardDelete(long num,ModelAndView mv) throws Exception{
		int result = noticeService.boardDelete(num);
		
		if(result > 0) {
			mv.setViewName("redirect:./noticeList");
		}else {
			mv.addObject("msg", "삭제 실패");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate")
	public ModelAndView boardUpdate(long num,ModelAndView mv) throws Exception{
		
		BoardVO boardVO = noticeService.boardSelect(num);
		
		mv.addObject("boardVO", boardVO);
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	@RequestMapping(value = "noticeUpdate",method = RequestMethod.POST)
	public ModelAndView boardUpdate2(BoardVO boardVO, ModelAndView mv) throws Exception{
		System.out.println("here");
		int result = noticeService.boardUpdate(boardVO);
		
		System.out.println(boardVO.getNum());
		if(result > 0) {
			mv.setViewName("redirect:./noticeSelect?num="+boardVO.getNum());
		}else {
			mv.setViewName("./noticeList");
		}
		
		return mv;
	}
	
 	
	
	@RequestMapping(value = "noticeList")
	public ModelAndView boardList(Pager pager,ModelAndView mv) throws Exception{
		
//		System.out.println("kind: " +pager.getKind());
//		System.out.println("search : " + pager.getSearch());
		
		List<BoardVO> ar = noticeService.boardList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager",pager);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeSelect")
	public ModelAndView boardSelect(long num) throws Exception{
		
		BoardVO boardVO = noticeService.boardSelect(num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", boardVO);
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	
	@RequestMapping(value = "noticeWrite")
	public String boardWrite2() throws Exception{
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "noticeWrite",method = RequestMethod.POST)
	public ModelAndView boardWrite(String title,String contents,String writer,ModelAndView mv) throws Exception{
		
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(title);
		boardVO.setContents(contents);
		boardVO.setWriter(writer);
		
		int result = noticeService.boardWrite(boardVO);
		if(result>0) {
			mv.setViewName("redirect:./noticeList");
		}else {
			mv.setViewName("common/result");
			mv.addObject("msg", "실패");
			mv.addObject("path", "./noticeList");
		}
		
		return mv;
		
	}
	
}
