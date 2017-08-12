package com.exam.proj.main.vo;

public class MainVO {
	
	private int rn;
	private int binum;
	private String title;
	private String content;
	private String writer;
	private String cdate;
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public int getBinum() {
		return binum;
	}
	public void setBinum(int binum) {
		this.binum = binum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MainVO [rn=" + rn + ", binum=" + binum + ", title=" + title
				+ ", content=" + content + ", writer=" + writer + ", cdate=" + cdate + "]";
	}

}
