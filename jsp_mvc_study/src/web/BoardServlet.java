package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Board;
import bean.User;
import service.BoardService;
import service.implement.BoardServiceImpl;

public class BoardServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private BoardService bs = new BoardServiceImpl();
	
	public String makeBoardList(String searchTitle){
		Board board = new Board();
		board.setBoardTitle(searchTitle);
		List<Board> boardList = bs.getBoardList(board);
		String result ="";
		result += "<table border='1'>";
		result += "<tr>";
		result += "<td colspan='5' align='center'>제목 : <input type='text' name='search_title' id='search_title'/>"
				+ "<input type='button' value='검색' onclick='doSearchBoard()'/></td>";
		result += "</tr>";
		result += "<tr>";
		result += "<td>게시판번호</td>";
		result += "<td>제목</td>";
		result += "<td>작성자</td>";
		result += "<td>작성일자</td>";
		result += "<td>삭제버튼</td>";
		result += "</tr>";
		if(boardList.size()==0){
			result += "<tr>";
			result += "<td colspan='5' align='center'>게시물이 존재하지 않습니다.</td>";
			result += "</tr>";
		}
		for(Board b : boardList){
			result += "<tr>";
			result += "<td>" + b.getBoardNum() +"</td>";
			result += "<td>" + b.getBoardTitle() +"</td>";
			result += "<td>" + b.getBoardWriter() +"</td>";
			result += "<td>" + b.getBoardCDate() +"</td>";
			result += "<td><input type='button' value='삭제' onclick='doBoardDelete(\"" + b.getBoardNum() + "\", \"" + b.getBoardWriter() + "\")'/></td>";
			result += "</tr>";
		}
		result += "<tr>";
		result += "<td colspan='5' align='right'><input type='button' value='게시글작성' onclick='goWriteJsp()'/></td>";
		result += "</tr>";
		result += "</table border>";
		return result;
	}
	public void doGet(HttpServletRequest request, HttpServletResponse resp) 
			throws IOException {
		//BOARDLIST
		//BOARDWRITE
		//BOARDMODIFY
		//BOARDDELETE
		//BOARDVIEW
		String action = request.getParameter("action");
		String result = "";
		HttpSession session = request.getSession();
		String searchTitle = request.getParameter("search_title");
		if(action.equals("BOARDLIST")){
			result += makeBoardList(searchTitle);
		}else if(action.equals("BOARDDELETE")){
			String boardWriter = request.getParameter("board_writer");
			Board board = new Board();
			int boardNum = Integer.parseInt(request.getParameter("board_num"));
			board.setBoardNum(boardNum);
			board = bs.getBoard(board);
			String id = (String)session.getAttribute("id");
			if(board.getBoardWriter().equals(id)){
				boolean isDelete = bs.doBoardDelete(boardNum);
				if(isDelete){
					result += "선택하신 게시물이 정상적으로 삭제되었습니다.";
				}else{
					result += "선택하신 게시물이 정상적으로 삭제되지 않았습니다.";
				}
			}else{
				result += "삭제하실 권한이 없습니다.";
			}
			result += makeBoardList(searchTitle);
		}else if(action.equals("BOARDWRITE")){
			String boardTitle = request.getParameter("title");
			String boardContent = request.getParameter("content");
			Board board = new Board();
			board.setBoardTitle(boardTitle);
			board.setBoardContent(boardContent);
			board.setBoardWriter((String)session.getAttribute("id"));
			board.setBoardModifier((String)session.getAttribute("id"));
			bs.doBoardWrite(board);
			
		}else if(action.equals("BOARDMODIFY")){
			
		}else if(action.equals("BOARDVIEW")){
			
		}else{
			result += "잘못된 action을 입력하셨습니다.";
		}

		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.println(result);
    }	
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }
    
}
