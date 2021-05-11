package com.company.view.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.biz.board.BoardVO;
import com.company.biz.board.impl.BoardDAO;

public class GetBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//ì¡°íšŒ ?•  row?˜ seq ë²ˆí˜¸ë¥? ë°›ëŠ”?‹¤.
		int num= Integer.parseInt(request.getParameter("num"));
		
		//DAO?— ë°›ì? ë²ˆí˜¸ë¥? ? „?‹¬?•˜ê³? ê·? ê²°ê³¼ê°’ì„ ë°›ëŠ”?‹¤.
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.getBoard(num);
		
		request.setAttribute("board", board);

		RequestDispatcher view = request.getRequestDispatcher("getBoard.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}