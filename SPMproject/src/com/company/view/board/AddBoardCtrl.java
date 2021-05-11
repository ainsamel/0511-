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
		String nickname = request.getParameter("nickname");
		String content = request.getParameter("content");
		
		//?��?��메터 받�? 값을 ?��개의 �??���? �?리하�? ?��?�� VO 객체?�� ?��?�� ?��?��
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setNickname(nickname);
		vo.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.addBoard(vo);
		
		if(cnt != 0) {
			response.sendRedirect("getBoardListCtrl");
		}else {
			response.sendRedirect("index.jsp");
		}
		
		response.sendRedirect("getBoardListCtrl");