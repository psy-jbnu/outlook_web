package org.duckdns.psyche503.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.duckdns.psyche503.Vo.ContactVo;

import java.util.ArrayList;
public class ContactDao {
    private ContactDao() {
        
    }
    private static ContactDao cDao = new ContactDao();
    
    public static ContactDao getInstance() {
        return cDao;
    }
    
    private Connection getConn() throws SQLException, NamingException{
        InitialContext ic = new InitialContext();
        DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
        return ds.getConnection();
    }

    public ArrayList<ContactVo> getAllContacts() {
        String sql = "Select * from contacts";
        ArrayList<ContactVo> contacts =  new ArrayList<ContactVo>();
        try (   Connection        conn   = getConn();
                PreparedStatement pstmt  = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ContactVo contact = new ContactVo();
                contact.setContactName(rs.getString("contactName"));
                contact.setTel(rs.getString("tel"));
                contact.setAddr(rs.getString("addr"));
                contact.setGroupId(rs.getInt("groupId"));
                contact.setEmail(rs.getString("email"));
                contact.setRegDate(rs.getDate("regDate"));
                
                contacts.add(contact);
            }
            
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return contacts;

    }

    public int deleteContacts(String[] tels) {
        int result = -1;
        String sql = "Delete from contacts where tel = ?";
        try (   Connection        conn   = getConn();
                PreparedStatement pstmt  = conn.prepareStatement(sql)) {
           for (String tel : tels) {
            pstmt.setString(1, tel);
            result += pstmt.executeUpdate();
           }
           
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }

    public ContactVo getContact(String tel) {
        String sql = "Select * from contacts where tel = ?";
        ContactVo contact = null;
        try (   Connection        conn   = getConn();
                PreparedStatement pstmt  = conn.prepareStatement(sql)) {
            pstmt.setString(1, tel);
            try(ResultSet rs = pstmt.executeQuery()){                
                
                if (rs.next()) {
                    
                    contact = new ContactVo();
                    contact.setContactName(rs.getString("contactName"));
                    contact.setTel(rs.getString("tel"));
                    contact.setAddr(rs.getString("addr"));
                    contact.setGroupId(rs.getInt("groupId"));
                    contact.setEmail(rs.getString("email"));
                    contact.setRegDate(rs.getDate("regDate"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contact;
    }

    public int insertContact(ContactVo contact) {
        int result = -1;
        String sql = "Insert Into contacts values(?, ?, ?, ?, ?, sysdate)";
        try (   Connection        conn   = getConn();
                PreparedStatement pstmt  = conn.prepareStatement(sql)) {
           pstmt.setString(1, contact.getTel());
           pstmt.setString(2, contact.getContactName());
           pstmt.setString(3, contact.getEmail());
           pstmt.setString(4, contact.getAddr());
           pstmt.setInt(5, contact.getGroupId());
           
           result = pstmt.executeUpdate(); 
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }

    public int updateContact(ContactVo contact, String oldTel) {
        int result = -1;
        String sql  =   "UPDATE CONTACTS            " 
                    +   "   SET TEL = ?             " 
                    +   "    ,  CONTACTNAME = ?     "  
                    +   "    ,  EMAIL = ?           "  
                    +   "    ,  ADDR = ?            "  
                    +   "    ,  GROUPID = ?         "  
                    +   " WHERE TEL = ?             ";
        try (   Connection        conn   = getConn();
                PreparedStatement pstmt  = conn.prepareStatement(sql)) {
           pstmt.setString(1, contact.getTel());
           pstmt.setString(2, contact.getContactName());
           pstmt.setString(3, contact.getEmail());
           pstmt.setString(4, contact.getAddr());
           pstmt.setInt(5, contact.getGroupId());
           pstmt.setString(6, oldTel);
           result = pstmt.executeUpdate(); 
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }

    public ArrayList<ContactVo> searchContacts(String searchVal) {
        String sql = "Select * from contacts WHERE TEL LIKE '%'||?||'%' OR contactNAME LIKE '%'||?||'%'";
        ArrayList<ContactVo> contacts = null;
        try (   Connection        conn   = getConn();
                PreparedStatement pstmt  = conn.prepareStatement(sql)) {
            pstmt.setString(1, searchVal);
            pstmt.setString(2, searchVal);
            
            try(ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    contacts = new ArrayList<ContactVo>();
                    ContactVo contact = new ContactVo();
                    contact.setContactName(rs.getString("contactName"));
                    contact.setTel(rs.getString("tel"));
                    contact.setAddr(rs.getString("addr"));
                    contact.setGroupId(rs.getInt("groupId"));
                    contact.setEmail(rs.getString("email"));
                    contact.setRegDate(rs.getDate("regDate"));
                    
                    contacts.add(contact);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return contacts;
    }

    public ArrayList<ContactVo> getMember(int groupId) {
        String sql = "Select * from contacts where groupId = ?";
        ArrayList<ContactVo> contacts = new ArrayList<ContactVo>();
        try (   Connection        conn   = getConn();
                PreparedStatement pstmt  = conn.prepareStatement(sql);) {
            pstmt.setInt(1, groupId);
            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    
                    ContactVo contact = new ContactVo();
                    contact.setContactName(rs.getString("contactName"));
                    contact.setTel(rs.getString("tel"));
                    contact.setAddr(rs.getString("addr"));
                    contact.setGroupId(rs.getInt("groupId"));
                    contact.setEmail(rs.getString("email"));
                    contact.setRegDate(rs.getDate("regDate"));
                    
                    contacts.add(contact);
                }
            }
            
            
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return contacts;
    }
    
    
    
}
