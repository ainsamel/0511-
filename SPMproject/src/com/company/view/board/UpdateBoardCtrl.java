package com.company.view.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.biz.board.BoardVO;
import com.company.biz.board.impl.BoardDAO;

public class UpdateBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int num  = Integer.parseInt(request.getParameter("num"));
		
		//넘어온값을 BoardVO에 다 담아서 한번에 전달
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSeq(num);
		
		BoardDAO dao = new BoardDAO();
		dao.updateBoard(vo);
		
		response.sendRedirect("getBoardListCtrl");
			
	
		
	

	}
}
