package com.company.view.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.biz.board.BoardVO;
import com.company.biz.board.impl.BoardDAO;

public class GetBoardListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAOë¡œë??„° ? „ì²? ë¦¬ìŠ¤?Š¸?˜ ê²°ê³¼ê°’ì„ ë°›ì•„?˜¨?‹¤.
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> boardList = dao.getBoardList();
		
		//ê°?? ¸?˜¨ ?°?´?„°ë¥? request?— ?‹´?Š”?‹¤. ???…?? Object ???…?œ¼ë¡? ìºìŠ¤?Œ…?˜?„œ ?‹´ê¸´ë‹¤.
		request.setAttribute("boardList", boardList);
		
		//?˜„?¬ ?‚¬?š©?•œ request?? responseë¥? getBoardList.jsp ?ŒŒ?¼?— ? „?‹¬?•˜ë©´ì„œ ?´?™
		RequestDispatcher view = request.getRequestDispatcher("getBoardList.jsp");
		view.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
