package com.company.view.board;

import java.io.IOException;

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
		
		//서블릿은 session이 내장객체가 아니므로 사용하려면 받아와야한다.
		HttpSession session = request.getSession();
		
		String name = (String)session.getAttribute("name");
		if(name == null){
			response.sendRedirect("login.jsp");
			return;
		}
		
		// 넘어오는 값 받기
		int num  = Integer.parseInt(request.getParameter("num"));
		
		//지금은 전달할 매개변수가 1개지만 추후 늘어날 경우 대비(유지보수)
		//BoardVO 객체에 담아 전달. int로 1개만 전달해도 됨
		BoardVO vo = new BoardVO();
		vo.setSeq(num);
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.deleteBoard(vo);
		
		
		// 리스트 페이지로 바로 이동
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
