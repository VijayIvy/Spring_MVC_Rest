package com.cts.nm.model;

import java.util.List;

public class OnboardWrapper {

	private List<OnboardDTO> m_lstOnboard;

	public List<OnboardDTO> getOnboard() {
		return m_lstOnboard;
	}

	public void setOnboard(List<OnboardDTO> p_lstOnboard) {
		this.m_lstOnboard = p_lstOnboard;
	}
}