package com.cts.nm.model;

public class UserConfigDTO {
	private Integer m_sRoleId;
	private String m_sRoleName;
	private Integer m_sLocationId;
	private String m_sLocationName;
	private String m_sLocationPDL;
	private String m_sUserName;
	private Integer m_sUserId;

	public int getRoleId() {
		return m_sRoleId;
	}

	public void setRoleId(int p_sRoleId) {
		this.m_sRoleId = p_sRoleId;
	}

	public String getRoleName() {
		return m_sRoleName;
	}

	public void setRoleName(String p_sRoleName) {
		this.m_sRoleName = p_sRoleName;
	}
	
	public int getLocationId() {
		return m_sLocationId;
	}

	public void setLocationId(int p_sLocationId) {
		this.m_sLocationId = p_sLocationId;
	}

	public String getLocationName() {
		return m_sLocationName;
	}

	public void setLocationName(String p_sLocationName) {
		this.m_sLocationName = p_sLocationName;
	}

	public String getLocationPDL() {
		return m_sLocationPDL;
	}

	public void setLocationPDL(String p_sLocationPDL) {
		this.m_sLocationPDL = p_sLocationPDL;
	}
	public String getUserName() {
		return m_sUserName;
	}

	public void setUserName(String p_sUserName) {
		this.m_sUserName = p_sUserName;
	}
	public int getUserId() {
		return m_sUserId;
	}

	public void setUserId(int p_sUserId) {
		this.m_sUserId = p_sUserId;
	}
}
