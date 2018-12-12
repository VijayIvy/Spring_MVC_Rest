package com.cts.nm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.nm.constant.NMConstants;
import com.cts.nm.model.OnboardDTO;
import com.cts.nm.model.OnboardWrapper;
import com.cts.nm.model.UserConfigDTO;
import com.cts.nm.model.UserRoleDTO;
import com.cts.nm.service.WorkflowService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class WorkflowController {
	@Autowired
	private WorkflowService m_objWorkflowService;

	@RequestMapping(value = "/saveWorkFlowRequest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Boolean saveWorkFlowRequest(@RequestBody OnboardDTO p_objOnboardDTO, HttpServletRequest p_objRequest) {
		System.out.println("Controller: saveWorkFlowRequest p_objOnboard" + p_objOnboardDTO);
		return m_objWorkflowService.saveWorkFlowRequest(p_objOnboardDTO);
	}

	@RequestMapping(value = "/retrieveWorkFlowDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<OnboardDTO> retrieveWorkFlowDetails(HttpServletRequest p_objRequest) {
		OnboardDTO p_objOnboardDTO = new OnboardDTO();
		//System.out.println("Controller: retrieveWorkFlowDetails onboardDTO" + p_objOnboardDTO);
		p_objOnboardDTO.setUserName(p_objRequest.getSession().getAttribute(NMConstants.NM_USER).toString());
		p_objOnboardDTO
				.setUserRole(Integer.parseInt(p_objRequest.getSession().getAttribute(NMConstants.NM_ROLE).toString()));
		return m_objWorkflowService.retrieveWorkFlowDetails(p_objOnboardDTO);
	}

	@RequestMapping(value = "/updateWorkFlowRequest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Boolean updateWorkFlowRequest(@RequestBody OnboardDTO p_objOnboard, HttpServletRequest p_objRequest) {
		System.out.println("Controller: updateWorkFlowRequest p_objOnboard" + p_objOnboard);
		return m_objWorkflowService.updateWorkFlowRequest(p_objOnboard);
	}

	@RequestMapping(value = "/getUnitDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<String> getUnitDetails() {
		System.out.println("Controller: getUnitDetails");
		return m_objWorkflowService.getUnitDetails();
	}

	@RequestMapping(value = "/getSubUnitDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<String> getSubUnitDetails() {
		System.out.println("Controller: getSubUnitDetails");
		return m_objWorkflowService.getSubUnitDetails();
	}

	@RequestMapping(value = "/getProjectTypeDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<String> getProjectTypeDetails() {
		System.out.println("Controller: getProjectTypeDetails");
		return m_objWorkflowService.getProjectTypeDetails();
	}

	@RequestMapping(value = "UserRoles", method = RequestMethod.POST)
	public List<UserConfigDTO> getRoles(HttpServletRequest p_objRequest) {

		return m_objWorkflowService.getRoles();
	}

	@RequestMapping(value = "getLocations", method = RequestMethod.POST)
	public List<UserConfigDTO> getLocations(HttpServletRequest p_objRequest) {

		return m_objWorkflowService.getLocations();
	}

	@RequestMapping(value = "getAssigneeUsers", method = RequestMethod.POST)
	public List<UserConfigDTO> getAssigneeUsers(HttpServletRequest p_objRequest) {

		return m_objWorkflowService.getAssigneeUsers();
	}

	@RequestMapping(value = "/searchWorkFlowDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<OnboardDTO> searchWorkFlowDetails(@RequestBody UserRoleDTO p_objSearchVal,
			HttpServletRequest p_objRequest) {
		OnboardDTO p_objOnboardDTO=new OnboardDTO();
		p_objOnboardDTO.setUserName(p_objRequest.getSession().getAttribute(NMConstants.NM_USER).toString());
		p_objOnboardDTO
				.setUserRole(Integer.parseInt(p_objRequest.getSession().getAttribute(NMConstants.NM_ROLE).toString()));
		p_objOnboardDTO.setSearch(p_objSearchVal.getSearch());
		return m_objWorkflowService.searchWorkFlowDetails(p_objOnboardDTO);
	}
	
	@RequestMapping(value = "/getDirectors", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<String> getDirectors() {
		System.out.println("Controller: getDirectors");
		return m_objWorkflowService.getDirectors();
	}
	
	@RequestMapping(value = "/getAnchors", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<String> getAnchors() {
		System.out.println("Controller: getAnchors");
		return m_objWorkflowService.getAnchors();
	}
}
