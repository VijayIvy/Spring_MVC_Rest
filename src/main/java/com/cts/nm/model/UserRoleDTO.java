package com.cts.nm.model;

public class UserRoleDTO {
	private String m_sUserRole;
	private String m_sUserName;
    private String m_sSearch;
	
	public String getSearch() {
		return m_sSearch;
	}

	public void setSearch(String p_sSearch) {
		this.m_sSearch = p_sSearch;
	}
	public String getUserRole() {
		return m_sUserRole;
	}

	public void setUserRole(String p_sUserRole) {
		this.m_sUserRole = p_sUserRole;
	}

	public String getUserName() {
		return m_sUserName;
	}

	public void setUserName(String p_sUserName) {
		this.m_sUserName = p_sUserName;
	}
}
