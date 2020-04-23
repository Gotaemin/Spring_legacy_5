package com.tm.s5.board.file;

public class BoardFileVO {

	private long fnum;
	private long num;
	private String fileName;
	private String oriName;
	private int board;
	
	
	public long getFnum() {
		return fnum;
	}
	public void setFnum(long fnum) {
		this.fnum = fnum;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public int getBoard() {
		return board;
	}
	public void setBoard(int board) {
		this.board = board;
	}

}
