package com.company.biz.board.impl;
//abc
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
   
   
   // 전체게시물 조회
   public ArrayList<BoardVO> getBoardList() {

      ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();

      try {
         //static 메서드라 클래스 이름으로 접근
         conn = JdbcConnection.getConnection();
         
         String sql = "select * from board order by seq desc";
         stmt = conn.prepareStatement(sql);

         rs = stmt.executeQuery();

         while (rs.next()) {
            BoardVO vo = new BoardVO();

            vo.setSeq(rs.getInt("seq"));
            vo.setUserid(rs.getString("userid"));
            vo.setUsername(rs.getString("username"));
            vo.setTitle(rs.getString("title"));
            vo.setContent(rs.getString("content"));
            vo.setRegdate(rs.getDate("regdate"));

            boardList.add(vo);
         }

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         JdbcConnection.close(rs, stmt, conn);
      }
      // 결과물을 담은 객체를 리턴
      return boardList;
   }

   // 게시물 1개 조회
   public BoardVO getBoard(int num) {

      BoardVO board = null;

      // 호출하는 곳에서 필요한 값을 전달. 따라서 매개변수로 처리한다.
      // int num = Integer.parseInt(request.getParameter("num"));

      try {
         conn = JdbcConnection.getConnection();
         
         String sql = "select * from board where seq = ?";
         stmt = conn.prepareStatement(sql);

         stmt.setInt(1, num);

         rs = stmt.executeQuery();

         if (rs.next()) {
            board = new BoardVO();

            board.setSeq(rs.getInt("seq"));
            board.setUserid(rs.getString("userid"));
            board.setUsername(rs.getString("username"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setRegdate(rs.getDate("regdate"));
            
         }

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         JdbcConnection.close(rs, stmt, conn);
         }
      
      // 쿼리 실행결과 1개를 호출한 곳으로 전달.
      return board;
   }

   // 게시물 입력
   public int addBoard(BoardVO vo) {

      int cnt = 0;

      try {
         conn = JdbcConnection.getConnection();
         
         String sql = "insert into board (seq, title, nickname, content) "
               + "values( (select nvl(max(seq), 0) + 1 from BOARD), ?, ?, ?)";

         stmt = conn.prepareStatement(sql);

         stmt.setString(1, vo.getTitle());
         stmt.setString(2, vo.getUsername());
         stmt.setString(3, vo.getContent());

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
      // 마지막에 실행된 개수 전달
      return cnt;

   }

   // 게시물 삭제
   public int deleteBoard(BoardVO vo) {
      
      int cnt = 0;
            
      try {
         conn = JdbcConnection.getConnection();
         
         String sql = "delete from board where seq = ?";
         stmt = conn.prepareStatement(sql);
         stmt.setInt(1, vo.getSeq());

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

   
   //게시물 수정
   public void updateBoard(BoardVO vo) {
      
      try {
         conn = JdbcConnection.getConnection();
         
         
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