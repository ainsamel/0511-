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
		
		//?„œë¸”ë¦¿?? session?´ ?‚´?¥ê°ì²´ê°? ?•„?‹ˆë¯?ë¡? ?‚¬?š©?•˜? ¤ë©? ë°›ì•„???•¼?•œ?‹¤.
		HttpSession session = request.getSession();
		
		String name = (String)session.getAttribute("name");
		if(name == null){
			response.sendRedirect("login.jsp");
			return;
		}
		
		// ?„˜?–´?˜¤?Š” ê°? ë°›ê¸°
		int num  = Integer.parseInt(request.getParameter("num"));
		
		//ì§?ê¸ˆì? ? „?‹¬?•  ë§¤ê°œë³??ˆ˜ê°? 1ê°œì?ë§? ì¶”í›„ ?Š˜?–´?‚  ê²½ìš° ??ë¹?(?œ ì§?ë³´ìˆ˜)
		//BoardVO ê°ì²´?— ?‹´?•„ ? „?‹¬. intë¡? 1ê°œë§Œ ? „?‹¬?•´?„ ?¨
		BoardVO vo = new BoardVO();
		vo.setSeq(num);
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.deleteBoard(vo);
		
		
		// ë¦¬ìŠ¤?Š¸ ?˜?´ì§?ë¡? ë°”ë¡œ ?´?™
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