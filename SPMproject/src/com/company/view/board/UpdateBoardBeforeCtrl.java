package com.company.view.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.biz.board.BoardVO;
import com.company.biz.board.impl.BoardDAO;

public class UpdateBoardBeforeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		int num = Integer.parseInt(request.getParameter("num"));
		
		//처리로직이 getBoard.jsp와 동일
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.getBoard(num);
		
		request.setAttribute("board", board);

		RequestDispatcher view = request.getRequestDispatcher("updateBoard.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}