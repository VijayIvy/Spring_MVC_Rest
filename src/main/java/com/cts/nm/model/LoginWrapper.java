package com.cts.nm.model;

import java.util.List;

public class LoginWrapper {

	private List<LoginVO> m_lstLoginDetails;

	public List<LoginVO> getLoginDetails() {
		return m_lstLoginDetails;
	}

	public void setLoginDetails(List<LoginVO> p_lstLoginDetails) {
		this.m_lstLoginDetails = p_lstLoginDetails;
	}
}