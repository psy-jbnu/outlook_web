package org.duckdns.psyche503.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class GroupDao {
    private GroupDao() {
        
    }
    private static GroupDao gDao = new GroupDao();
    
    public static GroupDao getInstance() {
        return gDao;
    }
    
    private Connection getConn() throws SQLException, NamingException{
        InitialContext ic = new InitialContext();
        DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
        return ds.getConnection();
    }

    public HashMap<Integer, String> getAllGroups() {
        HashMap<Integer, String> groups = new HashMap<Integer, String>();
       
        String sql = "Select * from contactGroups";
        try (   Connection        conn   = getConn();
                PreparedStatement pstmt  = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                
                groups.put(rs.getInt("groupId"), rs.getString("groupName"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return groups;
    }

    public int insertNewGroup(String groupName) {
        String sql = "Insert into ContactGroups Values((SELECT MAX(groupid)+1 FROM CONTACTGROUPS), ?, sysdate)";
        int result = -1;
        try (   Connection        conn   = getConn();
                PreparedStatement pstmt  = conn.prepareStatement(sql)) {
            pstmt.setString(1, groupName);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == 1) {
            sql = "SELECT MAX(groupid) FROM CONTACTGROUPS";
            try (   Connection        conn   = getConn();
                    PreparedStatement pstmt  = conn.prepareStatement(sql)) {
                try(ResultSet rs = pstmt.executeQuery();){
                    if (rs.next()) {
                        result = rs.getInt(1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = -1;
            }   
        }
        return result;
    }

    public int deleteGroup(int groupId) {
        String sql = "Delete from ContactGroups Where groupId = ?";
        int result = -1;
        try (   Connection        conn   = getConn();
                PreparedStatement pstmt  = conn.prepareStatement(sql)) {
            pstmt.setInt(1, groupId);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
        
    }
    
    
}
