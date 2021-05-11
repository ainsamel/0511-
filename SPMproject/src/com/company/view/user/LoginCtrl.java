package com.company.view.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.biz.user.UserVO;
import com.company.biz.user.impl.UserDAO;

public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doGet(request, response);

		// 처리 할 값 받기
		// request.setCharacterEncoding("UTF-8");

//		request.setCharacterEncoding("UTF-8"); // 항상 받기전에 줘야한다.

		String userid = request.getParameter("userid");
		String password = request.getParameter("password");

		// 받을 값을 DAO에 전달하기 위새 1개의 변수로 결합
		UserVO vo = new UserVO();
		vo.setUserid(userid);
		vo.setPassword(password);

		UserDAO dao = new UserDAO();

		// user가 있으면 UserVO 객체에 name값이 담겨져 넘어오고
		// 없으면 null이 넘어온다.
		UserVO user = dao.login(vo);

		if (user != null) {

			HttpSession session = request.getSession(); // 2
			session.setAttribute("username", user.getUsername()); // 세션객체는 내장 아님 1

			response.sendRedirect("mainCtrl");
		} else {
			response.sendRedirect("login.jsp");
		}
	}
}
