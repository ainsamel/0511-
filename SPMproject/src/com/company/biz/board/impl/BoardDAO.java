package com.company.biz.board.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.biz.board.BoardVO;
import com.company.biz.common.JdbcConnection;

public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	
	// ? μ²΄κ²?λ¬? μ‘°ν
	public ArrayList<BoardVO> getBoardList() {

		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();

		try {
			//static λ©μ??Ό ?΄??€ ?΄λ¦μΌλ‘? ? κ·?
			conn = JdbcConnection.getConncection();
			
			String sql = "select * from board order by seq desc";
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();

				vo.setnumber(rs.getInt("number"));
				vo.setusertype(rs.getString("usertype"));
				vo.setuserid(rs.getString("userid"));
				vo.setusername(rs.getString("username"));
				vo.settel(rs.getString("tel"));
				vo.setemail(rs.getString("email"));
				vo.setaddress(rs.getString("userid"));

				boardList.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.close(rs, stmt, conn);
		}
		// κ²°κ³Όλ¬Όμ ?΄?? κ°μ²΄λ₯? λ¦¬ν΄
		return boardList;
	}

	// κ²μλ¬? 1κ°? μ‘°ν
	public BoardVO getBoard(int num) {

		BoardVO board = null;

		// ?ΈμΆν? κ³³μ? ??? κ°μ ? ?¬. ?°?Ό? λ§€κ°λ³??λ‘? μ²λ¦¬??€.
		// int num = Integer.parseInt(request.getParameter("num"));

		try {
			conn = JdbcConnection.getConncection();
			
			String sql = "select * from board where seq = ?";
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, num);

			rs = stmt.executeQuery();

			if (rs.next()) {
				board = new BoardVO();

				board.setnumber(rs.getInt("number"));
				board.setusertype(rs.getString("usertype"));
				board.setuserid(rs.getString("userid"));
				board.setusername(rs.getString("username"));
				board.settel(rs.getString("tel"));
				board.setemail(rs.getString("email"));
				board.setaddress(rs.getString("address"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.close(rs, stmt, conn);
			}
		
		// μΏΌλ¦¬ ?€?κ²°κ³Ό 1κ°λ?? ?ΈμΆν κ³³μΌλ‘? ? ?¬.
		return board;
	}

	// κ²μλ¬? ?? ₯
	public int addBoard(BoardVO vo) {

		int cnt = 0;

		try {
			conn = JdbcConnection.getConncection();
			
			String sql = "insert into board (seq, title, nickname, content) "
					+ "values( (select nvl(max(seq), 0) + 1 from BOARD), ?, ?, ?)";

			stmt = conn.prepareStatement(sql);

			stmt.setString(1, vo.getuserid());
			stmt.setString(2, vo.getusertype());
			stmt.setString(3, vo.getusername());

			cnt = stmt.executeUpdate();

			if (cnt != 0) {
				conn.commit();
			}

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcConnection.close(stmt, conn);
		}
		// λ§μ?λ§μ ?€?? κ°μ ? ?¬
		return cnt;

	}

	// κ²μλ¬? ?­? 
	public int deleteBoard(BoardVO vo) {
		
		int cnt = 0;
				
		try {
			conn = JdbcConnection.getConncection();
			
			String sql = "delete from board where seq = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, vo.getnumber());

			cnt = stmt.executeUpdate();
			if (cnt != 0) {
				conn.commit();
			}

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcConnection.close(stmt, conn);
		}return cnt;
	}

	
	//κ²μλ¬? ?? 
	public void updateBoard(BoardVO vo) {
		
		try {
			conn = JdbcConnection.getConncection();
			
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userID = "hr";
			String userPW = "hr";

			conn = DriverManager.getConnection(url, userID, userPW);

			String sql = "update board set title = ?, content = ? where seq = ?";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			
			int cnt = stmt.executeUpdate();

			if(cnt != 0){
				conn.commit();
			}
			
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			JdbcConnection.close(stmt, conn);
		}
	}
	
	
	
}
