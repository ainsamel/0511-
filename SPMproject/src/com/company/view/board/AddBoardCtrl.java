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

import com.company.biz.board.BoardVO;
import com.company.biz.board.impl.BoardDAO;

public class AddBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String username = request.getParameter("username");
		String content = request.getParameter("content");
		
		//파라메터 받은 값을 한개의 변수로 관리하기 위해 VO 객체에 담아 전달
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setUsername(username);
		vo.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.addBoard(vo);
		
		if(cnt != 0) {
			response.sendRedirect("getBoardListCtrl");
		}else {
			response.sendRedirect("index.jsp");
		}
		
		response.sendRedirect("getBoardListCtrl");
		
		

	}

}