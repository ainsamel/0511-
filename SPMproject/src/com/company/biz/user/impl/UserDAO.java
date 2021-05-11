package com.company.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.biz.common.JdbcConnection;
import com.company.biz.user.UserVO;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// login
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
			if (rs.next()) {
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

	// logout
	public void logout() {

	}

	// insert 신규 회원 가입
	public int addUser(UserVO vo) {

		int cnt = 0;

		try {
			conn = JdbcConnection.getConnection();

			String sql = "insert into spuser(usernumber, usertype, userid, password, username, tel, email, address) values((select count(usernumber) from spuser)+1,'일반회원',?,?,?,?,?,?)";

			stmt = conn.prepareStatement(sql);

			stmt.setString(1, vo.getUserid());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getUsername());
			stmt.setString(4, vo.getTel());
			stmt.setString(5, vo.getEmail());
			stmt.setString(6, vo.getAddress());

			cnt = stmt.executeUpdate();
			if (cnt != 0) {
				conn.commit();
			}

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcConnection.close(stmt, conn);
		}
		// 마지막에 실행된 개수 전달
		return cnt;

	}

}
