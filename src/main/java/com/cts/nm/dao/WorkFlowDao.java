package com.cts.nm.dao;

import java.util.List;
import java.util.Map;

import com.cts.nm.model.OnboardDTO;
import com.cts.nm.model.OnboardWrapper;

public interface WorkFlowDao {
	
	public Boolean saveWorkFlowDetails(OnboardDTO p_objLoginVO);

	public List<OnboardDTO> retrieveWorkFlowDetails(OnboardDTO onboardDTO);

	public Boolean updateWorkFlowDetails(OnboardDTO p_objLoginVO);
	
	public List<String> getUnitDetails();
	
	public List<String> getSubUnitDetails();
	
	public List<String> getProjectTypeDetails();
	
	public List<Map<String, Object>> getRoles();
	
	public List<Map<String, Object>> getLocations();
	
	public List<Map<String, Object>> getAssigneeUsers();
	
	public List<OnboardDTO> searchWorkFlowDetails(OnboardDTO onboardDTO);
	
	public List<String> getDirectors();
	
	public List<String> getAnchors();
}