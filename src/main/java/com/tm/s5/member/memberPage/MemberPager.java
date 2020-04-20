package com.tm.s5.member.memberPage;

public class MemberPager {
	private Long perPage;
	private Integer curPage;
	
	private long startRow;
	private long lastRow;
	
	private long totalCount;
	private long totalPage;
	
	private long totalBlock;
	private long curBlock;
	private long startNum;
	private long lastNum;
	
	private String kind;
	private String search;
	
	

	public void makeRow() {
		this.startRow = (this.getCurPage()-1) * this.getPerPage() +1;
		this.lastRow = this.getCurPage() * this.getPerPage();
	}
	
	public void makePage(long totalCount) {
		
		this.totalPage = totalCount / this.perPage;
		if(totalCount % this.perPage != 0) {
			this.totalPage++;
		}
		
		long perBlock = 5L;
		
		this.totalBlock = this.totalPage / perBlock;
		if(this.totalPage % perBlock != 0) {
			this.totalBlock++;
		}
		
		this.curBlock = this.curPage / perBlock;
		if(this.curPage % perBlock != 0) {
			this.curBlock++;
		}
		
		this.startNum = (this.curBlock-1) * perBlock +1;
		this.lastNum = this.curBlock * perBlock;
		if(this.curBlock == this.totalBlock) {
			this.lastNum = this.totalPage;
		}
		
	
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

	public Long getPerPage() {
		if(this.perPage == null) {
			this.perPage = 10L;
		}
		
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Integer getCurPage() {
		if(this.curPage == null) {
			curPage = 1;
		}
		
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public long getStartRow() {
		return startRow;
	}
	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}
	public long getLastRow() {
		return lastRow;
	}
	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	
	
	
	public String getKind() {
		return kind;
	}

	public String getSearch() {
		
		if(this.search == null) {
			search = "";
		}
		return search;
	}
	
	
}
