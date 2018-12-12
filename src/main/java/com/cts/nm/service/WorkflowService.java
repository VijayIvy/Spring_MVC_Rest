package com.cts.nm.service;

import java.util.List;

import com.cts.nm.model.OnboardDTO;
import com.cts.nm.model.OnboardWrapper;
import com.cts.nm.model.UserConfigDTO;

public interface WorkflowService {
	public Boolean saveWorkFlowRequest(OnboardDTO onboardDTO);

	public List<OnboardDTO> retrieveWorkFlowDetails(OnboardDTO onboardDTO);

	public Boolean updateWorkFlowRequest(OnboardDTO p_objOnboard);
	
	public List<String> getUnitDetails();
	
	public List<String> getSubUnitDetails();
	
	public List<String> getProjectTypeDetails();
	
	public List<UserConfigDTO> getRoles();
	
	public List<UserConfigDTO> getLocations();
	
	public List<UserConfigDTO> getAssigneeUsers();
	
	public List<OnboardDTO> searchWorkFlowDetails(OnboardDTO onboardDTO);
	
	public List<String> getDirectors();
	
	public List<String> getAnchors();
}
