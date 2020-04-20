package com.tm.s5.board.page;

public class Pager {

	private Long curPage;
	private Integer perPage;

	private long startRow;
	private long lastRow;
	
	private long totalPage;
	private long totalBlock;
	

	private long curBlock;
	private long startNum;
	private long lastNum;
	
	
	private String kind;
	private String search;
	
	//
	public void makeRow() {
		this.startRow = (this.getCurPage() - 1) * this.getPerPage() + 1;
		this.lastRow = this.getCurPage() * this.getPerPage();
	}

	//페이지의 개수 계산
	public void makePage(long totalCount){
		// 총글의 개수
		// 총페이지의 개수
		this.totalPage = totalCount / this.getPerPage();
		if (totalCount % this.getPerPage() != 0) {
			this.totalPage++;
		}
		
		//totalPage로  totalBlock계산
		long perBlock = 5L;
		this.totalBlock = this.totalPage / perBlock;
		if(this.totalPage % perBlock != 0) {
			this.totalBlock++;	
		}
		
		//curPage로 curBlock을 계산
		this.curBlock = this.curPage / perBlock;
		if(this.curPage % perBlock != 0) {
			this.curBlock++;
		}
		
		//curBlock으로 startNum,lastNum 계산
		this.startNum = (this.curBlock-1) * perBlock +1;
		this.lastNum = this.curBlock * perBlock;
		
		if(this.curBlock == this.totalBlock) {
			this.lastNum = this.totalPage;
		}
		
		
	}
	
	

	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		
		if(this.search == null) {
			this.search = "";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	

	public long getTotalBlock() {
		return totalBlock;
	}

	public long getCurBlock() {
		return curBlock;
	}

	public long getStartNum() {
		return startNum;
	}

	public long getLastNum() {
		return lastNum;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public Long getCurPage() {
		if(this.curPage == null || this.curPage == 0) {
			this.curPage = 1L;
		}
		return curPage;
	}

	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}

	public long getStartRow() {
		return startRow;
	}

	public long getLastRow() {
		return lastRow;
	}

	public Integer getPerPage() {
		
		if(this.perPage == null || this.perPage == 0) {
			perPage = 10;
		}
		
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
}
