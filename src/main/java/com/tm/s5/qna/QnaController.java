package com.tm.s5.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tm.s5.board.BoardVO;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() throws Exception{
		return "qna";
	}

	// select(GET)
	@RequestMapping(value = "qnaSelect")
	public ModelAndView boardSelect(long num) throws Exception{
		
		BoardVO boardVO = qnaService.boardSelect(num);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", boardVO);
		mv.setViewName("board/boardSelect");
		
		return mv;
	}

	// list(GET)
	@RequestMapping(value = "qnaList")
	public ModelAndView boardList(@RequestParam(defaultValue = "1") int curPage, ModelAndView mv) throws Exception {

//		System.out.println(perPage);
//		System.out.println(curPage);

		List<BoardVO> ar = qnaService.boardList(curPage);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");

		return mv;
	}

	// update(GET/POST)
	@RequestMapping(value = "qnaUpdate")
	public ModelAndView boardUpdate(long num, ModelAndView mv) throws Exception {

		BoardVO boardVO = qnaService.boardSelect(num);

		mv.addObject("boardVO", boardVO);
		mv.setViewName("board/boardUpdate");

		return mv;
	}

	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate2(BoardVO boardVO, ModelAndView mv) throws Exception {
		System.out.println("here");
		int result = qnaService.boardUpdate(boardVO);

		System.out.println(boardVO.getNum());
		if (result > 0) {
			mv.setViewName("redirect:./qnaSelect?num=" + boardVO.getNum());
		} else {
			mv.setViewName("./qnaList");
		}

		return mv;
	}

	// delete(GET)
	@RequestMapping(value = "qnaDelete")
	public ModelAndView boardDelete(long num, ModelAndView mv) throws Exception {
		int result = qnaService.boardDelete(num);

		if (result > 0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("msg", "삭제 실패");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/result");
		}

		return mv;
	}

	// insert(GET/POST)
	@RequestMapping(value = "qnaWrite")
	public String boardWrite2() throws Exception{
		return "board/boardWrite";
	}

	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
public ModelAndView boardWrite(String title,String contents,String writer,ModelAndView mv) throws Exception{
		
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(title);
		boardVO.setContents(contents);
		boardVO.setWriter(writer);
		
		int result = qnaService.boardWrite(boardVO);
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.setViewName("common/result");
			mv.addObject("msg", "실패");
			mv.addObject("path", "./qnaList");
		}
		
		return mv;
		
	}

}
