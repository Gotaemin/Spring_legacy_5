package com.tm.s5.board.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/boardFile/**")
public class BoardFileController {

	@Autowired
	private BoardFileService boardFileSerivce;
	
	
	@PostMapping("summerDelete")
	public ModelAndView summerDelete(String fileName) throws Exception{
		ModelAndView mv = new ModelAndView();

		int result = boardFileSerivce.summerDelete(fileName);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	
	@PostMapping("fileInsert")
	public ModelAndView fileInsert(MultipartFile files) throws Exception{
		String fileName = boardFileSerivce.fileInsert(files);
		System.out.println("c:"+fileName);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", fileName);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	
	
	@PostMapping("fileDelete")
	@ResponseBody
	public int fileDelete(BoardFileVO boardFileVO) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		System.out.println("fnum: "+fnum);
		
		int result = boardFileSerivce.fileDelete(boardFileVO);
//		System.out.println(result);
//		
//		mv.addObject("result", result);
//		mv.setViewName("common/ajaxResult");
		
		return result;
	}
	
	
	
	@GetMapping("fileDown")
	public ModelAndView fileDown(BoardFileVO boardFileVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boardFileVO = boardFileSerivce.fileSelect(boardFileVO);
		
		mv.addObject("file", boardFileVO);
		mv.setViewName("fileDown");
		
		return mv;
	}
	
}
