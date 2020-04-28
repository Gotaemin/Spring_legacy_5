package com.tm.s5.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tm.s5.util.Pager;

public interface BoardService {

	// List
	public List<BoardVO> boardList(Pager pager) throws Exception;

	// Select One
	public BoardVO boardSelect(long num) throws Exception;

	// insert
	public int boardWrite(BoardVO boardVO,MultipartFile[] files) throws Exception;

	// delete
	public int boardDelete(long num) throws Exception;

	// update
	public int boardUpdate(BoardVO boardVO,MultipartFile[] files) throws Exception;

}
