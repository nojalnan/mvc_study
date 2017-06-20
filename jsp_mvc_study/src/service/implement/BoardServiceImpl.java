package service.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Board;
import common.DBConn;
import service.BoardService;

public class BoardServiceImpl implements BoardService {

	@Override
	public List<Board> getBoardList(Board board) {
		List<Board> boardList = new ArrayList<Board>();
		try {
			Connection con = DBConn.getCon();
			String sql = "select board_num, board_title, board_content, board_Writer, ";
			sql += "board_cdate, board_modifier, board_mdate from board where 1=1 ";
			if(board.getBoardTitle()!=null && !board.getBoardTitle().equals("")){
				sql += " and board_title like ?";
			}
			PreparedStatement pstmt = con.prepareStatement(sql);

			if(board.getBoardTitle()!=null && !board.getBoardTitle().equals("")){
				pstmt.setString(1, "%" + board.getBoardTitle() + "%");
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board1 = new Board();
				board1.setBoardNum(rs.getInt("board_num"));
				board1.setBoardTitle(rs.getString("board_title"));
				board1.setBoardContent(rs.getString("board_content"));
				board1.setBoardWriter(rs.getString("board_writer"));
				board1.setBoardCDate(rs.getString("board_cdate"));
				board1.setBoardModifier(rs.getString("board_modifier"));
				board1.setBoardMDate(rs.getString("board_mdate"));
				boardList.add(board1);
			}
			return boardList;
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				DBConn.closeCon();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return boardList;
	}

	@Override
	public boolean doBoardWrite(Board board) {
		try {
			Connection con = DBConn.getCon();
			String sql = "insert into board(board_title, board_content, board_writer"
						+",board_cdate, board_modifier, board_mdate)";
			sql += " values(?,?,?,now(),?,now())";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setString(3, board.getBoardWriter());
			pstmt.setString(4, board.getBoardModifier());
			int result = pstmt.executeUpdate();
			if(result==1){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean doBoardModify() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doBoardDelete(int boardNum) {
		try {
			Connection con = DBConn.getCon();
			String sql = "delete from board where board_num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			int result = pstmt.executeUpdate();
			if(result==1){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Board getBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board getBoard(Board board) {
		try {
			Connection con = DBConn.getCon();
			String sql = "select board_num, board_title, board_content, board_Writer, ";
			sql += "board_cdate, board_modifier, board_mdate from board where board_num=? ";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board.getBoardNum());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board1 = new Board();
				board1.setBoardNum(rs.getInt("board_num"));
				board1.setBoardTitle(rs.getString("board_title"));
				board1.setBoardContent(rs.getString("board_content"));
				board1.setBoardWriter(rs.getString("board_writer"));
				board1.setBoardCDate(rs.getString("board_cdate"));
				board1.setBoardModifier(rs.getString("board_modifier"));
				board1.setBoardMDate(rs.getString("board_mdate"));
				return board1;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				DBConn.closeCon();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	
}
