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
		
		//?��블릿?? session?�� ?��?��객체�? ?��?���?�? ?��?��?��?���? 받아???��?��?��.
		HttpSession session = request.getSession();
		
		String name = (String)session.getAttribute("name");
		if(name == null){
			response.sendRedirect("login.jsp");
			return;
		}
		
		// ?��?��?��?�� �? 받기
		int num  = Integer.parseInt(request.getParameter("num"));
		
		//�?금�? ?��?��?�� 매개�??���? 1개�?�? 추후 ?��?��?�� 경우 ??�?(?���?보수)
		//BoardVO 객체?�� ?��?�� ?��?��. int�? 1개만 ?��?��?��?�� ?��
		BoardVO vo = new BoardVO();
		vo.setSeq(num);
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.deleteBoard(vo);
		
		
		// 리스?�� ?��?���?�? 바로 ?��?��
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