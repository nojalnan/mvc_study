package com.exam.proj.main.vo;

public class MainVO {
	
	private int rn;
	private int board_num;
	private String title;
	private String content;
	private String writer;
	private String reg_date;
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		board_num = board_num;
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
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MainVO [rn=" + rn + ", board_num=" + board_num + ", title=" + title
				+ ", content=" + content + ", writer=" + writer + ", reg_date=" + reg_date + "]";
	}

}
