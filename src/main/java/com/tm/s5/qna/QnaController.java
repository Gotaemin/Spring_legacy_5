package com.tm.s5.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tm.s5.board.BoardVO;
import com.tm.s5.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() throws Exception{
		return "qna";
	}
	
	@GetMapping("qnaReply")
	public ModelAndView boardReply(ModelAndView mv,long num) throws Exception{

		mv.addObject("num", num);
		mv.setViewName("board/boardReply");
		return mv;
	}
	
	@PostMapping("qnaReply")
	public ModelAndView boardReply(ModelAndView mv,QnaVO qnaVO) throws Exception{
		
		int result = qnaService.boardReply(qnaVO);
		
		if(result > 0) {
			mv.setViewName("redirect:./qnaList");
		}else {
		
			mv.addObject("msg", "실패");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/result");
		}	
		
		return mv;
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
	@GetMapping("qnaList")
	public ModelAndView boardList(Pager pager, ModelAndView mv) throws Exception {

//		System.out.println("kind: " +pager.getKind());
//		System.out.println("search : " + pager.getSearch());
		
		List<BoardVO> ar = qnaService.boardList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager",pager);
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
	public ModelAndView boardUpdate2(BoardVO boardVO, MultipartFile[] files, ModelAndView mv) throws Exception {
		System.out.println("here");
		int result = qnaService.boardUpdate(boardVO,files);

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
	public ModelAndView boardWrite(QnaVO qnaVO,ModelAndView mv,MultipartFile[] files) throws Exception{
		
		int result = qnaService.boardWrite(qnaVO,files);
		
		if(result>0) {
			mv.addObject("msg", "성공");
		}else {
			mv.addObject("msg", "실패");
		}
		
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		return mv;
		
	}

}
