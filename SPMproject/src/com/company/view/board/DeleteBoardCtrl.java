package com.company.view.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.biz.board.BoardVO;
import com.company.biz.board.impl.BoardDAO;

public class DeleteBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//?λΈλ¦Ώ?? session?΄ ?΄?₯κ°μ²΄κ°? ??λ―?λ‘? ?¬?©?? €λ©? λ°μ???Ό??€.
		HttpSession session = request.getSession();
		
		String name = (String)session.getAttribute("name");
		if(name == null){
			response.sendRedirect("login.jsp");
			return;
		}
		
		// ??΄?€? κ°? λ°κΈ°
		int num  = Integer.parseInt(request.getParameter("num"));
		
		//μ§?κΈμ? ? ?¬?  λ§€κ°λ³??κ°? 1κ°μ?λ§? μΆν ??΄?  κ²½μ° ??λΉ?(? μ§?λ³΄μ)
		//BoardVO κ°μ²΄? ?΄? ? ?¬. intλ‘? 1κ°λ§ ? ?¬?΄? ?¨
		BoardVO vo = new BoardVO();
		vo.setSeq(num);
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.deleteBoard(vo);
		
		
		// λ¦¬μ€?Έ ??΄μ§?λ‘? λ°λ‘ ?΄?
		if(cnt != 0) {
			response.sendRedirect("getBoardListCtrl");
		}else {
			response.sendRedirect("index.jsp");
		}
		
			
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}