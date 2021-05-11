package domain;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnectionPool;

public class UserDAO {

    private DBConnectionPool connPool;
    private static final String RETRIEVE_STMT
            = "SELECT * FROM spuser WHERE UserType=? AND UserID=? AND Password =?";
    private static final String GETID_STMT = "SELECT COUNT(UserNumber) FROM spuser";
    private static final String CREATE_STMT = "INSERT INTO spuser VALUES(?,?,?,?,?,?,?,?,?)";

    User userRetrieve(String usertype, String userid, String password) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        int rows = 0;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(RETRIEVE_STMT);
            stmt.setString(1, usertype);
            stmt.setString(2, userid);
            stmt.setString(3, password);
            rset = stmt.executeQuery();
            while (rset.next()) {
             
                int UserNumber =rset.getInt("UserNumber");
                String UserType = rset.getString("UserType");
                String UserID = rset.getString("UserID");
                String UserName = rset.getString("UserName");
                String Password = rset.getString("Password");
                String Email = rset.getString("Email");
                String Tel = rset.getString("Tel");
                String Address = rset.getString("Address");
                rows++;
                
                if (rows > 1) {
                    throw new SQLException("Too many rows were returned.");
                }
                user = new User(UserNumber, UserType, UserID, UserName, Password, Email, Tel, Address);
            }
            return user;
        } catch (SQLException se) {
            throw new RuntimeException(
                    "A database error occurred. " + se.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Exception: " + e.getMessage());
        } finally {
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    void userCreate(String usertype, String userid, String password, String username,  String email, String tel, String address) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        try {
            conn = connPool.getPoolConnection();
            stmt = conn.prepareStatement(GETID_STMT);
            rset = stmt.executeQuery();
            int usernumber= -1;
            rset.next();
            usernumber = rset.getInt("COUNT(UserNumber)");
            usernumber++;
            stmt = conn.prepareStatement(CREATE_STMT);
            stmt.setInt(1, usernumber);
            stmt.setString(2, usertype);
            stmt.setString(3, userid);
            stmt.setString(4, password);
            stmt.setString(5, username);
            stmt.setString(6, tel);
            stmt.setString(7, email);
            stmt.setString(8, address);
            stmt.executeQuery();
        } catch (SQLException se) {
            throw new RuntimeException(
                    "A database error occurred. " + se.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}