package org.duckdns.psyche503.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.duckdns.psyche503.Vo.UserVo;

public class UserDao {
	private UserDao() {
		
	}
	private static UserDao uDao = new UserDao();
	
	public static UserDao getInstance() {
		return uDao;
	}
	
	private Connection getConn() throws SQLException, NamingException{
		InitialContext ic = new InitialContext();
		DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
		return ds.getConnection();
	}
	
	
	
	public UserVo getUser(UserVo user) {
		String sql = "SELECT userEmail, pwd FROM USERS where userEmail = ?"; // 아이디, pwd 가져오고 loginHistory 기록
		UserVo uVo = null;
		String ipAddress = user.getIpAddress();
		try	(   Connection        conn	 = getConn();
		        PreparedStatement pstmt  = conn.prepareStatement(sql)) {
			pstmt.setString(1, user.getUserEmail());
			try(ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    uVo = new UserVo();
                    uVo.setUserEmail(rs.getString("userEmail"));
                    uVo.setPwd(rs.getString("pwd"));
                    uVo.setIpAddress(ipAddress);
                }
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return uVo;
	}
	
	public void writeLoginHis(String ipAddress, int isSuccess) {
	    String sql = "Insert into Login_History(ipAddress , isSuccess) Values(?,?)"; 
	    try (   Connection        conn   = getConn();
	            PreparedStatement pstmt  = conn.prepareStatement(sql)) {
	      pstmt.setString(1, ipAddress);
	      pstmt.setInt(2, isSuccess);
	      pstmt.executeUpdate();
	    
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    
	}

    public int updateUser(UserVo user) {
        String sql = "Update users set userEmail = ? , pwd= ?"; 
        int result = -1;
        try (   Connection        conn   = getConn();
                PreparedStatement pstmt  = conn.prepareStatement(sql)) {
          pstmt.setString(1, user.getUserEmail());
          pstmt.setString(2, user.getPwd());
          result = pstmt.executeUpdate();
        
        } catch (Exception e) {
          e.printStackTrace();
        }
        return result;
    }
}
