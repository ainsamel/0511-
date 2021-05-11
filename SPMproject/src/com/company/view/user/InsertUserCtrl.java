package com.company.view.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.biz.user.UserVO;
import com.company.biz.user.impl.UserDAO;

public class InsertUserCtrl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		// 받을 값을 DAO에 전달하기 위새 1개의 변수로 결합
		UserVO vo = new UserVO();
		vo.setUserid(userid);
		vo.setPassword(password);
		vo.setUsername(username);;
		vo.setTel(tel);
		vo.setEmail(email);
		vo.setAddress(address);

		UserDAO dao = new UserDAO();

		int cnt = dao.addUser(vo);
		
		System.out.println("cnt : " + cnt);
		if (cnt != 0) {
			response.sendRedirect("login.jsp"); // 회원가입 들어간거니까 로그인 화면으로 가고
		} else {
			response.sendRedirect("loginFail.jsp"); //
		}

	}

}
