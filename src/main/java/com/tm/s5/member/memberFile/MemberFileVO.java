package com.tm.s5.member.memberFile;

public class MemberFileVO {
	private String id;
	private String fileName;
	private String oriName;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
