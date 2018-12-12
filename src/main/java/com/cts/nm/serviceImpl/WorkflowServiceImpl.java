package com.cts.nm.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.cts.nm.dao.WorkFlowDao;
import com.cts.nm.model.OnboardDTO;
import com.cts.nm.model.OnboardWrapper;
import com.cts.nm.model.UserConfigDTO;
import com.cts.nm.service.WorkflowService;

@Service
@Scope("prototype")
public class WorkflowServiceImpl implements WorkflowService {

	@Autowired
	private WorkFlowDao m_objWorkFlowDao;

	@Override
	public Boolean saveWorkFlowRequest(OnboardDTO p_objOnboard) {
		Boolean isUserDetail = m_objWorkFlowDao.saveWorkFlowDetails(p_objOnboard);
		return isUserDetail;
	}

	@Override
	public List<OnboardDTO> retrieveWorkFlowDetails(OnboardDTO onboardDTO) {
		return (List<OnboardDTO>) m_objWorkFlowDao.retrieveWorkFlowDetails(onboardDTO);
	}

	@Override
	public Boolean updateWorkFlowRequest(OnboardDTO p_objOnboard) {
		Boolean isUserDetail = m_objWorkFlowDao.updateWorkFlowDetails(p_objOnboard);
		return isUserDetail;
	}

	@Override
	public List<String> getUnitDetails() {
		return m_objWorkFlowDao.getUnitDetails();
	}

	@Override
	public List<String> getSubUnitDetails() {
		return m_objWorkFlowDao.getSubUnitDetails();
	}

	@Override
	public List<String> getProjectTypeDetails() {
		return m_objWorkFlowDao.getProjectTypeDetails();
	}
	
	public List<UserConfigDTO> getRoles(){

		List<UserConfigDTO> l_objGetRoles = new ArrayList<UserConfigDTO>();
		List<Map<String, Object>> m_lstData = null;
		try {
			
			m_lstData = m_objWorkFlowDao.getRoles();

			if (m_lstData != null && !m_lstData.isEmpty()) {
				for (Map<String, Object> m_lstMapValue : m_lstData) {
					UserConfigDTO l_objGetRolesDTO = new UserConfigDTO();

					l_objGetRolesDTO.setRoleId((int)m_lstMapValue.get("ROLE_ID"));
					l_objGetRolesDTO.setRoleName(m_lstMapValue.get("ROLE_NAME").toString());
					/*Integer nullVal = null;
					l_objGetRolesDTO.setUserId((Integer)nullVal);												
					l_objGetRolesDTO.setLocationId((Integer)nullVal);;*/
					l_objGetRoles.add(l_objGetRolesDTO);
				}
			} 

		} catch (Exception p_objEx) {
			p_objEx.getMessage();
		}
		return l_objGetRoles;
	
	}
	
	public List<UserConfigDTO> getLocations(){

		List<UserConfigDTO> l_objGetLocations = new ArrayList<UserConfigDTO>();
		List<Map<String, Object>> m_lstData = null;
		try {
			
			m_lstData = m_objWorkFlowDao.getLocations();

			if (m_lstData != null && !m_lstData.isEmpty()) {
				for (Map<String, Object> m_lstMapValue : m_lstData) {
					UserConfigDTO l_objGetLocationsDTO = new UserConfigDTO();

					l_objGetLocationsDTO.setLocationId((int)m_lstMapValue.get("LOCATION_ID"));
					l_objGetLocationsDTO.setLocationName(m_lstMapValue.get("LOCATION_NAME").toString());
					l_objGetLocationsDTO.setLocationPDL(m_lstMapValue.get("LOCATION_PDL").toString());

					l_objGetLocations.add(l_objGetLocationsDTO);
				}
			} 

		} catch (Exception p_objEx) {
			p_objEx.getMessage();
		}
		return l_objGetLocations;
	}
	public List<UserConfigDTO> getAssigneeUsers(){

		List<UserConfigDTO> l_objGetAssigneeUsers = new ArrayList<UserConfigDTO>();
		List<Map<String, Object>> m_lstData = null;
		try {
			
			m_lstData = m_objWorkFlowDao.getAssigneeUsers();

			if (m_lstData != null && !m_lstData.isEmpty()) {
				for (Map<String, Object> m_lstMapValue : m_lstData) {
					UserConfigDTO l_objGetAssigneeUsersDTO = new UserConfigDTO();
					l_objGetAssigneeUsersDTO.setUserId((int)m_lstMapValue.get("USER_ID"));
					l_objGetAssigneeUsersDTO.setLocationId((int)m_lstMapValue.get("LOCATION_ID"));
					l_objGetAssigneeUsersDTO.setUserName(m_lstMapValue.get("USER_NAME").toString());

					l_objGetAssigneeUsers.add(l_objGetAssigneeUsersDTO);
				}
			} 

		} catch (Exception p_objEx) {
			p_objEx.getMessage();
		}
		return l_objGetAssigneeUsers;
	
	}
	
	@Override
	public List<OnboardDTO> searchWorkFlowDetails(OnboardDTO onboardDTO) {
		return (List<OnboardDTO>) m_objWorkFlowDao.searchWorkFlowDetails(onboardDTO);
	}

	@Override
	public List<String> getDirectors() {
		return m_objWorkFlowDao.getDirectors();
	}

	@Override
	public List<String> getAnchors() {
		return m_objWorkFlowDao.getAnchors();
	}

}
