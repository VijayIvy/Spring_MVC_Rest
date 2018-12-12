package com.cts.nm.model;

public class LoginVO {
	private String m_sUserName;
	private String m_sPassword;

	public String getUserName() {
		return m_sUserName;
	}

	public void setUserName(String p_sUserName) {
		this.m_sUserName = p_sUserName;
	}

	public String getPassword() {
		return m_sPassword;
	}

	public void setPassword(String p_sPassword) {
		this.m_sPassword = p_sPassword;
	}
}
