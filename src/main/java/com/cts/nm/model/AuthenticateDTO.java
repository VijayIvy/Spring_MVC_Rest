package com.cts.nm.model;

public class AuthenticateDTO {

	private String m_sLoginStatusMsg;

	private String username;
	private String password;
	private String m_sUserRole;	
	private String m_sHeaderToken;
	private String m_sLogOutStatusMsg;
	
	public String getHeaderToken() {
		return m_sHeaderToken;
	}

	public void setHeaderToken(String p_sHeaderToken) {
		this.m_sHeaderToken = p_sHeaderToken;
	} 

	public String getLoginStatusMsg() {
		return m_sLoginStatusMsg;
	}

	public void setLoginStatusMsg(String p_sLoginStatusMsg) {
		this.m_sLoginStatusMsg = p_sLoginStatusMsg;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return m_sUserRole;
	}

	public void setUserRole(String p_sUserRole) {
		this.m_sUserRole = p_sUserRole;
	}
	
	public String getLogOutStatusMsg() {
		return m_sLogOutStatusMsg;
	}

	public void setLogOutStatusMsg(String p_sLogOutStatusMsg) {
		this.m_sLogOutStatusMsg = p_sLogOutStatusMsg;
	}
}
