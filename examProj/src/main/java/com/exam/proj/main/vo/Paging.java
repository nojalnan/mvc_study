package com.exam.proj.main.vo;

public class Paging {

	private int nowPage = 1; // 현재 페이지 디폴트 1
	private int totalCnt; //데이터 전체 수
	private int rowCnt = 10; //한페이지에 보일 게시물 수 디폴트 10
	private int blockCnt = 10; // 한페이지에 보일 페이지 수 디폴트 10
	private int totalPage; // 총 페이지 수	
	private int totalBlock; //총 블락 갯수

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public Paging(){
	}
	
	private void calPaging(){
		calTotalPage();
		calTotalBlock();
	}
	
	private void calTotalPage(){
		totalPage = (int) Math.ceil((double)totalCnt/rowCnt);
	}
	
	private void calTotalBlock(){
		totalBlock = (int) Math.ceil((double)totalPage/blockCnt);
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
		calPaging();
	}

	public int getRowCnt() {
		return rowCnt;
	}

	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}

	public int getBlockCnt() {
		return blockCnt;
	}

	public void setBlockCnt(int blockCnt) {
		this.blockCnt = blockCnt;
	}
	
	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

	public int getNowPage() {
		return nowPage;
	}
	
	public int getStartNum(){
		int startNum =  nowPage-1;
		if(startNum <=0){
			return 0;
		}
		return startNum*rowCnt;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
		if(this.totalPage>this.nowPage){
			this.nowPage = this.totalPage;
		}
	}	
	
	public int getNowBlock(){
		return ((this.nowPage-1)/10) * rowCnt +1;
	}
	
	public int getEndBlock(){
		int endBlock = getNowBlock() + rowCnt-1;
		if(endBlock>totalPage){
			endBlock = totalPage;
		}
		return endBlock;
	}
}
