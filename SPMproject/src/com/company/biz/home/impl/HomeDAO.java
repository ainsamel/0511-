package com.company.biz.home.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.company.biz.common.JdbcConnection;
import com.company.biz.home.HomeVO;

public class HomeDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;	
	
	 public ArrayList<HomeVO> mainList() {
	
		 ArrayList<HomeVO> mainList = new ArrayList<HomeVO>();
	
		
		 
		 try {
			 conn = JdbcConnection.getConnection();
		    	
	         String sql = "select * from main order by seq desc";
	         stmt = conn.prepareStatement(sql);

	         rs = stmt.executeQuery();
	         
	         while (rs.next()) {

	        	 HomeVO vo = new HomeVO(); // while문을 돌면서 vo 마지막으로 받아온 데이터만 기억한다.
	             // 따라서 arraylist(공간 동적할당) 에 각 주소 저장
	             vo.setNumber(rs.getInt("number"));
	             vo.setUsertype(rs.getString("usertype"));
	             vo.setUserid(rs.getString("userid"));
	             vo.setPassword(rs.getString("password"));
	             vo.setUsername(rs.getString("username"));
	             vo.setTel(rs.getString("tel"));
	             vo.setEamil(rs.getString("email"));
	             vo.setAddress(rs.getString("address"));

	             mainList.add(vo);

	          }
	         
	         
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcConnection.close(rs, stmt, conn);
		}
		 
		 return mainList; 
	 }
}
















