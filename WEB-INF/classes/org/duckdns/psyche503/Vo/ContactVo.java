package org.duckdns.psyche503.Vo;

import java.io.Serializable;
import java.util.Date;

public class ContactVo implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String tel;
    private String contactName;
    private String email;
    private String addr;
    private int groupId;
    private Date regDate;
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
 
    
}
