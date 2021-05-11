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
		//DAO로�??�� ?���? 리스?��?�� 결과값을 받아?��?��.
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> boardList = dao.getBoardList();
		
		//�??��?�� ?��?��?���? request?�� ?��?��?��. ???��?? Object ???��?���? 캐스?��?��?�� ?��긴다.
		request.setAttribute("boardList", boardList);
		
		//?��?�� ?��?��?�� request?? response�? getBoardList.jsp ?��?��?�� ?��?��?��면서 ?��?��
		RequestDispatcher view = request.getRequestDispatcher("getBoardList.jsp");
		view.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
