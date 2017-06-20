package service;

import java.util.List;

import bean.Board;

public interface BoardService {


	//BOARDLIST
	//BOARDWRITE
	//BOARDMODIFY
	//BOARDDELETE
	//BOARDVIEW
	public List<Board> getBoardList(Board board);

	public Board getBoard(Board board);
	public boolean doBoardWrite(Board board);
	public boolean doBoardModify();
	public boolean doBoardDelete(int boardNum);
	public Board getBoard();
}
