package com.company.view.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.biz.home.HomeVO;
import com.company.biz.home.impl.HomeDAO;

public class mainCtrl extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // DAO로부터 전체 리스트의 결과값을 받아온다.
      HomeDAO dao = new HomeDAO();
      ArrayList<HomeVO> mainList = dao.mainList();
      // 가져온 데이터를 request에 담는다. 타입은 Object 타입으로 캐스팅돼서 담긴다.
      request.setAttribute("boardList", boardList);

      // 현재 사용한 request와 response를 getBoardList.jsp 파일에 전달하면서 이동
      RequestDispatcher view = request.getRequestDispatcher("mainList.jsp");
      view.forward(request, response);

   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doGet(request, response);
   }

}