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
		//DAOλ‘λ??° ? μ²? λ¦¬μ€?Έ? κ²°κ³Όκ°μ λ°μ?¨?€.
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> boardList = dao.getBoardList();
		
		//κ°?? Έ?¨ ?°?΄?°λ₯? request? ?΄??€. ????? Object ????Όλ‘? μΊμ€??? ?΄κΈ΄λ€.
		request.setAttribute("boardList", boardList);
		
		//??¬ ?¬?©? request?? responseλ₯? getBoardList.jsp ??Ό? ? ?¬?λ©΄μ ?΄?
		RequestDispatcher view = request.getRequestDispatcher("getBoardList.jsp");
		view.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
