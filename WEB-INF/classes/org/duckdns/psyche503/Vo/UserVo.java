package org.duckdns.psyche503.Vo;

import java.io.Serializable;

public class UserVo implements Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String userEmail;
	private String pwd;
	private String ipAddress;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
	
}
