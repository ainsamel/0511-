package com.company.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.company.biz.common.JdbcConnection;
import com.company.biz.user.UserVO;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public UserVO login(UserVO vo) {
		UserVO user = null;

		try {
			conn = JdbcConnection.getConnection();

			String sql = "select * from users where id = ? and password = ?";
			stmt = conn.prepareStatement(sql);

//			stmt.setInt(1, vo.getNumber());
//			stmt.setString(2, vo.getUsertype());
			stmt.setString(1, vo.getUserid());
			stmt.setString(2, vo.getPassword());
//			stmt.setString(5, vo.getUsername());
//			stmt.setString(6, vo.getTel());
//			stmt.setString(7, vo.getEmail());
//			stmt.setString(8, vo.getAddress());

			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
//				user.setId(rs.getString("id"));	 사실상 필요하지 않다.
				user.setUsername(rs.getString("name"));	
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.close(rs, stmt, conn);
		}

		return user;
}
	public void logout() {
	
	}
	
}
	
	
	
	
