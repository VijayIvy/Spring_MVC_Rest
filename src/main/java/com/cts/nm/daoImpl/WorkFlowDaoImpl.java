package com.cts.nm.daoImpl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.nm.constant.NMConstants;
import com.cts.nm.dao.WorkFlowDao;
import com.cts.nm.model.MailDetails;
import com.cts.nm.model.NmDetails;
import com.cts.nm.model.OnboardDTO;
import com.cts.nm.model.OnboardWrapper;
import com.cts.nm.util.BlobUtil;
import com.cts.nm.util.EmailUtil;

@Scope("prototype")
@Repository
public class WorkFlowDaoImpl implements WorkFlowDao {
	@Autowired
	private NamedParameterJdbcTemplate m_objNamedParameterJdbcTemplate;
	private DataSource m_objDataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private BlobUtil blobUtil;

	@Autowired
	private EmailUtil emailUtil;

	public void setDataSource(DataSource p_objDataSource) {
		this.m_objDataSource = p_objDataSource;
		this.m_objNamedParameterJdbcTemplate = new NamedParameterJdbcTemplate(p_objDataSource);
		this.jdbcTemplate = new JdbcTemplate(p_objDataSource);
	}

	public Properties getPropValuesForQuery() throws IOException {
		Properties l_objProps = new Properties();
		InputStream l_objInputStream = getClass().getClassLoader().getResourceAsStream("query.properties");
		l_objProps.load(l_objInputStream);
		return l_objProps;
	}

	@Override
	public Boolean saveWorkFlowDetails(OnboardDTO l_objOnboard) {
		Boolean getuserDetails = false;
		int locationId = 0;
		try {
			System.out.println("InSide saveWorkFlowDetails Impl");
			String query = "insert into NM_WORKFLOW_DETAILS (FIRST_NAME, LAST_NAME, CTS_EMP_ID, CTS_EMAIL_ID, ONBOARD_STATUS, ONBOARD_COORDINATOR, "
					+ " PROJECT_NAME, CTS_JOIN_DATE, NM_JOIN_DATE, NM_END_DATE, TEAM_NAME, LOCATION, LOCATION_ID, PROJECT_ROLE, UNIT, SUB_UNIT, "
					+ " DIRECTORS, ANCHORS, NM_PROJECT_TYPE, NM_SOW, NM_LAN_ID, NM_IS_MANGAGER, CLASSIFICATION, REASON, ASSIGN_TO, "
					+ " NM_OFFBOARD_STATUS, NM_OFFBOARD_COORDINATOR, NM_ADDITIONAL_DETAILS, UPDATED_DATE, LAST_UPDATED_DATE, NM_DETAILS ) "
					+ " values (:FIRST_NAME, :LAST_NAME, :CTS_EMP_ID, :CTS_EMAIL_ID, :ONBOARD_STATUS, :ONBOARD_COORDINATOR, :PROJECT_NAME, :CTS_JOIN_DATE, "
					+ " :NM_JOIN_DATE, :NM_END_DATE, :TEAM_NAME, :LOCATION, :LOCATION_ID, :PROJECT_ROLE, :UNIT, :SUB_UNIT, :DIRECTORS, "
					+ " :ANCHORS, :NM_PROJECT_TYPE, :NM_SOW, :NM_LAN_ID, :NM_IS_MANGAGER, :CLASSIFICATION, :REASON, :ASSIGN_TO, "
					+ " :NM_OFFBOARD_STATUS, :NM_OFFBOARD_COORDINATOR, :NM_ADDITIONAL_DETAILS, :UPDATED_DATE, :LAST_UPDATED_DATE, :NM_DETAILS)";
			Map<String, Object> map = new HashMap<String, Object>();
			
			
			java.sql.Date date = getCurrentDatetime();
			blobUtil.setNmDetails(l_objOnboard);
			File file = new File("C:/Users/735081/Desktop/NMJML/BlobTestFiles/Source/Blobfile.xml");
			FileInputStream input = new FileInputStream(file);

			//for (OnboardDTO l_objOnboard : p_objOnboard) {
				map.put("FIRST_NAME", l_objOnboard.getFirstName());
				map.put("LAST_NAME", l_objOnboard.getLastName());
				map.put("CTS_EMP_ID", l_objOnboard.getCtsEmpId());
				map.put("CTS_EMAIL_ID", l_objOnboard.getCtsEmailId());
				map.put("ONBOARD_STATUS", l_objOnboard.getOnBoardStatus());
				map.put("ONBOARD_COORDINATOR", l_objOnboard.getOnBoardCoordinator());
				map.put("PROJECT_NAME", l_objOnboard.getProjectName());
				map.put("CTS_JOIN_DATE", l_objOnboard.getCtsJoinDate());
				map.put("NM_JOIN_DATE", l_objOnboard.getNmJoinDate());
				map.put("NM_END_DATE", l_objOnboard.getNmEndDate());
				map.put("TEAM_NAME", l_objOnboard.getTeamName());
				map.put("LOCATION", l_objOnboard.getLocation());
				map.put("LOCATION_ID", l_objOnboard.getLocationId());
				locationId = l_objOnboard.getLocationId();
				map.put("PROJECT_ROLE", l_objOnboard.getProjectRole());
				map.put("UNIT", l_objOnboard.getUnit());
				map.put("SUB_UNIT", l_objOnboard.getSubUnit());
				map.put("DIRECTORS", l_objOnboard.getDirectors());
				map.put("ANCHORS", l_objOnboard.getAnchors());
				map.put("NM_PROJECT_TYPE", l_objOnboard.getNmProjectType());
				map.put("NM_SOW", l_objOnboard.getNmSow());
				map.put("NM_LAN_ID", l_objOnboard.getNmLanId());
				map.put("NM_IS_MANGAGER", l_objOnboard.getNmIsManager());
				map.put("CLASSIFICATION", l_objOnboard.getClassification());
				map.put("REASON", l_objOnboard.getReason());
				map.put("ASSIGN_TO", l_objOnboard.getAssignTo());
				map.put("NM_OFFBOARD_STATUS", l_objOnboard.getNmOffBoardStatus());
				map.put("NM_OFFBOARD_COORDINATOR", l_objOnboard.getNmOffBoardCoordinator());
				map.put("NM_ADDITIONAL_DETAILS", l_objOnboard.getNmAdditionalDetails());
				map.put("UPDATED_DATE", date);
				map.put("LAST_UPDATED_DATE", date);
				map.put("NM_DETAILS", input);
			//}

			int result = m_objNamedParameterJdbcTemplate.update(query, map);
			System.out.println("InSide saveWorkFlowDetails result" + result);
			if (result == 1) {
				getuserDetails = true;
				System.out.println("InSide saveWorkFlowDetails getuserDetails " + getuserDetails);
			}
			System.out.println("Successfully Saved");
			MailDetails l_objMailservice = new MailDetails();
			String locationPOC = getLocationPOC(locationId);
			l_objMailservice.setToCc(locationPOC);
			l_objMailservice.setToMail(map.get("ASSIGN_TO").toString());
			l_objMailservice.setMsgSubject("Update");
			l_objMailservice.setMsgBody("Message Body");
			emailUtil.sendEmail(l_objMailservice);
			return getuserDetails;
		} catch (Exception ex) {
			System.out.println("saveWorkFlowDetails Exception   " + ex.getMessage());
		}
		return getuserDetails;
	}

	@Override
	public List<OnboardDTO> retrieveWorkFlowDetails(OnboardDTO onboardDTO) {
		List<Map<String, Object>> m_objData = null;
		List<OnboardDTO> result = new ArrayList<OnboardDTO>();

		String query = null;
		String userName = onboardDTO.getUserName();
		int roleId = onboardDTO.getUserRole();
		int LocationId = retrieveWorkFlowDetailsLocationID(userName, roleId);
		try {
			Map<String, Object> l_mapAttributes = new HashMap<String, Object>();
			if (roleId == 1) {
				query = getPropValuesForQuery().getProperty("retrieveWorkFlowDetailsForSuperAdmin");
				System.out.println("retrieveWorkFlowDetailsForSuperAdmin: query" + query);
			} else if (roleId == 2) {
				query = getPropValuesForQuery().getProperty("retrieveWorkFlowDetailsForAssigner");
				System.out.println("retrieveWorkFlowDetailsForAssigner: query" + query);
				l_mapAttributes.put("LOCATION_ID", LocationId);
			} else if (roleId == 3) {
				query = getPropValuesForQuery().getProperty("retrieveWorkFlowDetailsForAssignee");
				System.out.println("retrieveWorkFlowDetailsForAssignee: query" + query);
				l_mapAttributes.put("LOCATION_ID", LocationId);
				l_mapAttributes.put("ASSIGN_TO", userName);
			}

			m_objData = m_objNamedParameterJdbcTemplate.queryForList(query, l_mapAttributes);
			System.out.println("m_sData" + m_objData);
			if (m_objData != null) {
				for (Map<String, Object> map : m_objData) {
					OnboardDTO ObjOnboardDTO = new OnboardDTO();
					ObjOnboardDTO.setUserName(userName);
					ObjOnboardDTO.setUserRole(roleId);
					ObjOnboardDTO.setWorkFlowId(map.get("WORK_FLOW_ID") == null ? null
							: Integer.parseInt(map.get("WORK_FLOW_ID").toString()));
					ObjOnboardDTO.setFirstName(map.get("FIRST_NAME") == null ? "" : map.get("FIRST_NAME").toString());
					ObjOnboardDTO.setLastName(map.get("LAST_NAME") == null ? "" : map.get("LAST_NAME").toString());
					ObjOnboardDTO.setCtsEmpId(
							Integer.parseInt(map.get("CTS_EMP_ID") == null ? "" : map.get("CTS_EMP_ID").toString()));
					ObjOnboardDTO
							.setCtsEmailId(map.get("CTS_EMAIL_ID") == null ? "" : map.get("CTS_EMAIL_ID").toString());
					ObjOnboardDTO.setOnBoardStatus(
							map.get("ONBOARD_STATUS") == null ? "" : map.get("ONBOARD_STATUS").toString());
					ObjOnboardDTO.setOnBoardCoordinator(
							map.get("ONBOARD_COORDINATOR") == null ? "" : map.get("ONBOARD_COORDINATOR").toString());
					ObjOnboardDTO
							.setProjectName(map.get("PROJECT_NAME") == null ? "" : map.get("PROJECT_NAME").toString());
					ObjOnboardDTO.setCtsJoinDate(
							map.get("CTS_JOIN_DATE") == null ? "" : map.get("CTS_JOIN_DATE").toString());
					ObjOnboardDTO
							.setNmJoinDate(map.get("NM_JOIN_DATE") == null ? "" : map.get("NM_JOIN_DATE").toString());
					ObjOnboardDTO.setNmEndDate(map.get("NM_END_DATE") == null ? "" : map.get("NM_END_DATE").toString());
					ObjOnboardDTO.setTeamName(map.get("TEAM_NAME") == null ? "" : map.get("TEAM_NAME").toString());
					ObjOnboardDTO.setLocation(map.get("LOCATION") == null ? "" : map.get("LOCATION").toString());
					ObjOnboardDTO.setLocationId(map.get("LOCATION_ID") == null ? null
							: Integer.parseInt(map.get("LOCATION_ID").toString()));
					ObjOnboardDTO
							.setProjectRole(map.get("PROJECT_ROLE") == null ? "" : map.get("PROJECT_ROLE").toString());
					ObjOnboardDTO.setUnit(map.get("UNIT") == null ? "" : map.get("UNIT").toString());
					ObjOnboardDTO.setSubUnit(map.get("SUB_UNIT") == null ? "" : map.get("SUB_UNIT").toString());
					ObjOnboardDTO.setDirectors(map.get("DIRECTORS") == null ? "" : map.get("DIRECTORS").toString());
					ObjOnboardDTO.setAnchors(map.get("ANCHORS") == null ? "" : map.get("ANCHORS").toString());
					ObjOnboardDTO.setNmProjectType(
							map.get("NM_PROJECT_TYPE") == null ? "" : map.get("NM_PROJECT_TYPE").toString());
					ObjOnboardDTO.setNmSow(map.get("NM_SOW") == null ? "" : map.get("NM_SOW").toString());
					ObjOnboardDTO.setNmLanId(map.get("NM_LAN_ID") == null ? "" : map.get("NM_LAN_ID").toString());
					ObjOnboardDTO.setNmIsManager(
							map.get("NM_IS_MANGAGER") == null ? "" : map.get("NM_IS_MANGAGER").toString());
					ObjOnboardDTO.setClassification(
							map.get("CLASSIFICATION") == null ? "" : map.get("CLASSIFICATION").toString());
					ObjOnboardDTO.setReason(map.get("REASON") == null ? "" : map.get("REASON").toString());
					ObjOnboardDTO.setAssignTo(map.get("ASSIGN_TO") == null ? "" : map.get("ASSIGN_TO").toString());
					ObjOnboardDTO.setNmOffBoardStatus(
							map.get("NM_OFFBOARD_STATUS") == null ? "" : map.get("NM_OFFBOARD_STATUS").toString());
					ObjOnboardDTO.setNmOffBoardCoordinator(map.get("NM_OFFBOARD_COORDINATOR") == null ? ""
							: map.get("NM_OFFBOARD_COORDINATOR").toString());
					if (map.get("NM_DETAILS") != null) {
						byte[] configxml = (byte[]) map.get("NM_DETAILS");
						InputStream binaryInput = new ByteArrayInputStream(configxml);
						//FileOutputStream fileoutputstream;

						NmDetails nmDetail = blobUtil.getNmDetails(binaryInput);

						ObjOnboardDTO.setNmDetailId(nmDetail.getNmDetailId() == 0 ? null : nmDetail.getNmDetailId());
						ObjOnboardDTO.setMutualCodeOfConduct(
								nmDetail.getMutualCodeOfConduct() == null ? null : nmDetail.getMutualCodeOfConduct());
						ObjOnboardDTO.setDrugTestException(
								nmDetail.getDrugTestException() == null ? null : nmDetail.getDrugTestException());
						ObjOnboardDTO.setPrivacyBasics(
								nmDetail.getPrivacyBasics() == null ? null : nmDetail.getPrivacyBasics());
						ObjOnboardDTO.setNewMachineRequest(
								nmDetail.getNewMachineRequest() == null ? null : nmDetail.getNewMachineRequest());
						ObjOnboardDTO.setSignOnForm(nmDetail.getSignOnForm() == null ? null : nmDetail.getSignOnForm());
						ObjOnboardDTO.setPpmForm(nmDetail.getPpmForm() == null ? null : nmDetail.getPpmForm());
						ObjOnboardDTO.setNdaForm(nmDetail.getNdaForm() == null ? null : nmDetail.getNdaForm());
						ObjOnboardDTO.setNmDrugTestReRaised(
								nmDetail.getNmDrugTestReRaised() == null ? null : nmDetail.getNmDrugTestReRaised());
						ObjOnboardDTO.setNmIntroductionTraining(nmDetail.getNmIntroductionTraining() == null ? null
								: nmDetail.getNmIntroductionTraining());
						ObjOnboardDTO.setNmDLUpdate(nmDetail.getNmDLUpdate() == null ? null : nmDetail.getNmDLUpdate());
						ObjOnboardDTO.setNmDrugTest(nmDetail.getNmDrugTest() == null ? null : nmDetail.getNmDrugTest());
						ObjOnboardDTO.setProdTermId(nmDetail.getProdTermId() == null ? null : nmDetail.getProdTermId());
					}
					result.add(ObjOnboardDTO);
				}
			}
			System.out.println("result" + result);
			return result;
		} catch (Exception p_objEx) {
			p_objEx.getMessage();
			System.out.println("retrieveWorkFlowDetails Exception" + p_objEx.getMessage());
		}
		return result;
	}

	public int retrieveWorkFlowDetailsLocationID(String userName, int roleId) {
		System.out.println("retrieveWorlFlowDetailsLocationID userName:" + userName + " roleId:" + roleId);
		int locationID = 0;
		List<Map<String, Object>> m_objData = null;
		String query = "SELECT LOCATION_ID FROM NM_USER_LOGIN where USER_NAME = :USER_NAME and ROLE_ID= :ROLE_ID;";
		try {
			Map<String, Object> l_mapAttributes = new HashMap<String, Object>();
			l_mapAttributes.put("USER_NAME", userName);
			l_mapAttributes.put("ROLE_ID", roleId);

			m_objData = (List<Map<String, Object>>) m_objNamedParameterJdbcTemplate.queryForList(query,
					l_mapAttributes);
			System.out.println("m_sData" + m_objData);
			for (Map<String, Object> map : m_objData) {
				locationID = Integer.parseInt(map.get("LOCATION_ID").toString());
			}
			System.out.println("locationID" + locationID);
		} catch (Exception p_objEx) {
			p_objEx.getMessage();
			System.out.println("retrieveWorlFlowDetailsLocationID Exception" + p_objEx.getMessage());
		}

		return locationID;
	}

	public java.sql.Date getCurrentDatetime() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	@Override
	public Boolean updateWorkFlowDetails(OnboardDTO l_objOnboard) {

		Boolean getuserDetails = false;
		try {
			System.out.println("InSide updateWorkFlowDetails Impl");

			String updateQuery = "UPDATE NM_WORKFLOW_DETAILS SET ONBOARD_STATUS= :ONBOARD_STATUS, ONBOARD_COORDINATOR= :ONBOARD_COORDINATOR, PROJECT_NAME= :PROJECT_NAME, "
					+ " CTS_JOIN_DATE= :CTS_JOIN_DATE, NM_JOIN_DATE= :NM_JOIN_DATE, NM_END_DATE= :NM_END_DATE, TEAM_NAME= :TEAM_NAME, LOCATION= :LOCATION, "
					+ " LOCATION_ID= :LOCATION_ID, PROJECT_ROLE= :PROJECT_ROLE, UNIT= :UNIT, SUB_UNIT= :SUB_UNIT, DIRECTORS= :DIRECTORS, "
					+ " ANCHORS= :ANCHORS, NM_PROJECT_TYPE= :NM_PROJECT_TYPE, NM_SOW= :NM_SOW, LAST_UPDATED_DATE= :LAST_UPDATED_DATE, NM_LAN_ID= :NM_LAN_ID, "
					+ " NM_IS_MANGAGER= :NM_IS_MANGAGER, CLASSIFICATION= :CLASSIFICATION, REASON= :REASON, ASSIGN_TO= :ASSIGN_TO, NM_OFFBOARD_STATUS= :NM_OFFBOARD_STATUS, "
					+ " NM_ADDITIONAL_DETAILS= :NM_ADDITIONAL_DETAILS, NM_DETAILS= :NM_DETAILS WHERE CTS_EMP_ID = :CTS_EMP_ID";
			Map<String, Object> map = new HashMap<String, Object>();

			java.sql.Date date = getCurrentDatetime();
			blobUtil.setNmDetails(l_objOnboard);
			File file = new File("C:/Users/735081/Desktop/NMJML/BlobTestFiles/Source/Blobfile.xml");
			FileInputStream input = new FileInputStream(file);

			//for (OnboardDTO l_objOnboard : p_objOnboard.getOnboard()) {
				map.put("FIRST_NAME", l_objOnboard.getFirstName());
				map.put("LAST_NAME", l_objOnboard.getLastName());
				map.put("CTS_EMP_ID", l_objOnboard.getCtsEmpId());
				map.put("CTS_EMAIL_ID", l_objOnboard.getCtsEmailId());
				map.put("ONBOARD_STATUS", l_objOnboard.getOnBoardStatus());
				map.put("ONBOARD_COORDINATOR", l_objOnboard.getOnBoardCoordinator());
				map.put("PROJECT_NAME", l_objOnboard.getProjectName());
				map.put("CTS_JOIN_DATE", l_objOnboard.getCtsJoinDate());
				map.put("NM_JOIN_DATE", l_objOnboard.getNmJoinDate());
				map.put("NM_END_DATE", l_objOnboard.getNmEndDate());
				map.put("TEAM_NAME", l_objOnboard.getTeamName());
				map.put("LOCATION", l_objOnboard.getLocation());
				map.put("LOCATION_ID", l_objOnboard.getLocationId());
				map.put("PROJECT_ROLE", l_objOnboard.getProjectRole());
				map.put("UNIT", l_objOnboard.getUnit());
				map.put("SUB_UNIT", l_objOnboard.getSubUnit());
				map.put("DIRECTORS", l_objOnboard.getDirectors());
				map.put("ANCHORS", l_objOnboard.getAnchors());
				map.put("NM_PROJECT_TYPE", l_objOnboard.getNmProjectType());
				map.put("NM_SOW", l_objOnboard.getNmSow());
				map.put("NM_LAN_ID", l_objOnboard.getNmLanId());
				map.put("NM_IS_MANGAGER", l_objOnboard.getNmIsManager());
				map.put("CLASSIFICATION", l_objOnboard.getClassification());
				map.put("REASON", l_objOnboard.getReason());
				map.put("ASSIGN_TO", l_objOnboard.getAssignTo());
				map.put("NM_OFFBOARD_STATUS", l_objOnboard.getNmOffBoardStatus());
				map.put("NM_OFFBOARD_COORDINATOR", l_objOnboard.getNmOffBoardCoordinator());
				map.put("UPDATED_DATE", date);
				map.put("LAST_UPDATED_DATE", date);
				map.put("NM_ADDITIONAL_DETAILS", l_objOnboard.getNmAdditionalDetails());
				map.put("NM_DETAILS", input);
			//}

			int result = m_objNamedParameterJdbcTemplate.update(updateQuery, map);
			System.out.println("InSide updateWorkFlowDetails result" + result);
			if (result == 1) {
				getuserDetails = true;
				System.out.println("InSide updateWorkFlowDetails getuserDetails " + getuserDetails);
			}
			System.out.println("Successfully Updated");
			MailDetails l_objMailservice = new MailDetails();
			l_objMailservice.setToMail(map.get("ASSIGN_TO").toString());
			l_objMailservice.setMsgSubject("Update");
			l_objMailservice.setMsgBody("Message Body");
			emailUtil.sendEmail(l_objMailservice);
			return getuserDetails;
		} catch (Exception ex) {
			System.out.println("updateWorkFlowDetails Exception   " + ex.getMessage());
		}
		return getuserDetails;
	}

	@Override
	public List<String> getUnitDetails() {
		List<String> m_objData = null;
		String query = "SELECT USER_VALUE FROM NM_CONFIG WHERE USER_KEY = :UNIT";
		try {
			Map<String, Object> l_mapAttributes = new HashMap<String, Object>();
			l_mapAttributes.put("UNIT", NMConstants.NM_UNIT);

			m_objData = m_objNamedParameterJdbcTemplate.queryForList(query, l_mapAttributes, String.class);
			System.out.println("InSide getUnitDetails m_objData: " + m_objData);
		} catch (Exception p_objEx) {
			p_objEx.getMessage();
			System.out.println("getUnitDetails Exception" + p_objEx.getMessage());
		}
		return m_objData;
	}

	@Override
	public List<String> getSubUnitDetails() {
		List<String> m_objData = null;
		String query = "SELECT USER_VALUE FROM NM_CONFIG WHERE USER_KEY = :SUB_UNIT";

		try {
			Map<String, Object> l_mapAttributes = new HashMap<String, Object>();
			l_mapAttributes.put("SUB_UNIT", NMConstants.NM_SUB_UNIT);

			m_objData = m_objNamedParameterJdbcTemplate.queryForList(query, l_mapAttributes, String.class);
			System.out.println("InSide getUnitDetails m_objData: " + m_objData);
		} catch (Exception p_objEx) {
			p_objEx.getMessage();
			System.out.println("getUnitDetails Exception" + p_objEx.getMessage());
		}
		return m_objData;
	}

	@Override
	public List<String> getProjectTypeDetails() {
		List<String> m_objData = null;
		String query = "SELECT USER_VALUE FROM NM_CONFIG WHERE USER_KEY = :NM_PROJECT_TYPE";

		try {
			Map<String, Object> l_mapAttributes = new HashMap<String, Object>();
			l_mapAttributes.put("NM_PROJECT_TYPE", NMConstants.NM_PROJECT_TYPE);

			m_objData = m_objNamedParameterJdbcTemplate.queryForList(query, l_mapAttributes, String.class);
			System.out.println("InSide getUnitDetails m_objData: " + m_objData);
		} catch (Exception p_objEx) {
			p_objEx.getMessage();
			System.out.println("getUnitDetails Exception" + p_objEx.getMessage());
		}
		return m_objData;
	}

	public List<Map<String, Object>> getRoles() {
		List<Map<String, Object>> m_lstData = null;
		try {
			Map<String, Object> l_mapAttributes = new HashMap<String, Object>();
			m_lstData = m_objNamedParameterJdbcTemplate.queryForList(getPropValuesForQuery().getProperty("getRoles"),
					l_mapAttributes);

		} catch (Exception p_objEx) {
			p_objEx.getMessage();
		}
		return m_lstData;
	}

	public List<Map<String, Object>> getLocations() {
		List<Map<String, Object>> m_lstData = null;
		try {
			Map<String, Object> l_mapAttributes = new HashMap<String, Object>();
			m_lstData = m_objNamedParameterJdbcTemplate
					.queryForList(getPropValuesForQuery().getProperty("getLocations"), l_mapAttributes);

		} catch (Exception p_objEx) {
			p_objEx.getMessage();
		}
		return m_lstData;
	}

	public List<Map<String, Object>> getAssigneeUsers() {
		List<Map<String, Object>> m_lstData = null;
		try {
			Map<String, Object> l_mapAttributes = new HashMap<String, Object>();
			m_lstData = m_objNamedParameterJdbcTemplate
					.queryForList(getPropValuesForQuery().getProperty("getAssigneeUsers"), l_mapAttributes);

		} catch (Exception p_objEx) {
			p_objEx.getMessage();
		}
		return m_lstData;
	}

	@Override
	public List<OnboardDTO> searchWorkFlowDetails(OnboardDTO p_objOnboardDTO) {
		List<Map<String, Object>> m_objData = null;
		List<OnboardDTO> l_lstResult = new ArrayList<OnboardDTO>();

		String l_sUserName = p_objOnboardDTO.getUserName();
		int l_sRoleId = p_objOnboardDTO.getUserRole();
		String l_sQuery = null;
		int l_intLocationId = retrieveWorkFlowDetailsLocationID(l_sUserName, l_sRoleId);
		try {
			Map<String, Object> l_mapAttributes = new HashMap<String, Object>();
			l_mapAttributes.put("SEARCH_VAL", "%"+p_objOnboardDTO.getSearch()+"%");
			if (l_sRoleId == 1) {
				l_sQuery = getPropValuesForQuery().getProperty("getSearchWorkFlowDetailsForSuperAdmin");
			} else if (l_sRoleId == 2) {
				l_sQuery = getPropValuesForQuery().getProperty("getSearchWorkFlowDetailsForAssigner");
				l_mapAttributes.put("LOCATION_ID", l_intLocationId);
			} else if (l_sRoleId == 3) {
				l_sQuery = getPropValuesForQuery().getProperty("getSearchWorkFlowDetailsForAssignee");
				l_mapAttributes.put("LOCATION_ID", l_intLocationId);
				l_mapAttributes.put("ASSIGN_TO", l_intLocationId);
			}

			
			m_objData = m_objNamedParameterJdbcTemplate.queryForList(l_sQuery, l_mapAttributes);
			if (m_objData != null) {
				for (Map<String, Object> map : m_objData) {
					OnboardDTO l_ObjOnboardDTO = new OnboardDTO();
					l_ObjOnboardDTO.setUserName(l_sUserName);
					l_ObjOnboardDTO.setUserRole(l_sRoleId);
					l_ObjOnboardDTO.setWorkFlowId(map.get("WORK_FLOW_ID") == null ? null
							: Integer.parseInt(map.get("WORK_FLOW_ID").toString()));
					l_ObjOnboardDTO.setFirstName(map.get("FIRST_NAME") == null ? "" : map.get("FIRST_NAME").toString());
					l_ObjOnboardDTO.setLastName(map.get("LAST_NAME") == null ? "" : map.get("LAST_NAME").toString());
					l_ObjOnboardDTO.setCtsEmpId(
							Integer.parseInt(map.get("CTS_EMP_ID") == null ? "" : map.get("CTS_EMP_ID").toString()));
					l_ObjOnboardDTO
							.setCtsEmailId(map.get("CTS_EMAIL_ID") == null ? "" : map.get("CTS_EMAIL_ID").toString());
					l_ObjOnboardDTO.setOnBoardStatus(
							map.get("ONBOARD_STATUS") == null ? "" : map.get("ONBOARD_STATUS").toString());
					l_ObjOnboardDTO.setOnBoardCoordinator(
							map.get("ONBOARD_COORDINATOR") == null ? "" : map.get("ONBOARD_COORDINATOR").toString());
					l_ObjOnboardDTO
							.setProjectName(map.get("PROJECT_NAME") == null ? "" : map.get("PROJECT_NAME").toString());
					l_ObjOnboardDTO.setCtsJoinDate(
							map.get("CTS_JOIN_DATE") == null ? "" : map.get("CTS_JOIN_DATE").toString());
					l_ObjOnboardDTO
							.setNmJoinDate(map.get("NM_JOIN_DATE") == null ? "" : map.get("NM_JOIN_DATE").toString());
					l_ObjOnboardDTO.setNmEndDate(map.get("NM_END_DATE") == null ? "" : map.get("NM_END_DATE").toString());
					l_ObjOnboardDTO.setTeamName(map.get("TEAM_NAME") == null ? "" : map.get("TEAM_NAME").toString());
					l_ObjOnboardDTO.setLocation(map.get("LOCATION") == null ? "" : map.get("LOCATION").toString());
					/*ObjOnboardDTO.setLocationId(map.get("LOCATION_ID") == null ? null
							: Integer.parseInt(map.get("LOCATION_ID").toString()));*/
					l_ObjOnboardDTO
							.setProjectRole(map.get("PROJECT_ROLE") == null ? "" : map.get("PROJECT_ROLE").toString());
					l_ObjOnboardDTO.setUnit(map.get("UNIT") == null ? "" : map.get("UNIT").toString());
					l_ObjOnboardDTO.setSubUnit(map.get("SUB_UNIT") == null ? "" : map.get("SUB_UNIT").toString());
					l_ObjOnboardDTO.setDirectors(map.get("DIRECTORS") == null ? "" : map.get("DIRECTORS").toString());
					l_ObjOnboardDTO.setAnchors(map.get("ANCHORS") == null ? "" : map.get("ANCHORS").toString());
					l_ObjOnboardDTO.setNmProjectType(
							map.get("NM_PROJECT_TYPE") == null ? "" : map.get("NM_PROJECT_TYPE").toString());
					l_ObjOnboardDTO.setNmSow(map.get("NM_SOW") == null ? "" : map.get("NM_SOW").toString());
					l_ObjOnboardDTO.setNmLanId(map.get("NM_LAN_ID") == null ? "" : map.get("NM_LAN_ID").toString());
					l_ObjOnboardDTO.setNmIsManager(
							map.get("NM_IS_MANGAGER") == null ? "" : map.get("NM_IS_MANGAGER").toString());
					l_ObjOnboardDTO.setClassification(
							map.get("CLASSIFICATION") == null ? "" : map.get("CLASSIFICATION").toString());
					l_ObjOnboardDTO.setReason(map.get("REASON") == null ? "" : map.get("REASON").toString());
					l_ObjOnboardDTO.setAssignTo(map.get("ASSIGN_TO") == null ? "" : map.get("ASSIGN_TO").toString());
					l_ObjOnboardDTO.setNmOffBoardStatus(
							map.get("NM_OFFBOARD_STATUS") == null ? "" : map.get("NM_OFFBOARD_STATUS").toString());
					l_ObjOnboardDTO.setNmOffBoardCoordinator(map.get("NM_OFFBOARD_COORDINATOR") == null ? ""
							: map.get("NM_OFFBOARD_COORDINATOR").toString());
					
					if (map.get("NM_DETAILS") != null) {
						byte[] configxml = (byte[]) map.get("NM_DETAILS");
						InputStream binaryInput = new ByteArrayInputStream(configxml);
						NmDetails nmDetail = blobUtil.getNmDetails(binaryInput);

						l_ObjOnboardDTO.setNmDetailId(nmDetail.getNmDetailId() == 0 ? null : nmDetail.getNmDetailId());
						l_ObjOnboardDTO.setMutualCodeOfConduct(
								nmDetail.getMutualCodeOfConduct() == null ? null : nmDetail.getMutualCodeOfConduct());
						l_ObjOnboardDTO.setDrugTestException(
								nmDetail.getDrugTestException() == null ? null : nmDetail.getDrugTestException());
						l_ObjOnboardDTO.setPrivacyBasics(
								nmDetail.getPrivacyBasics() == null ? null : nmDetail.getPrivacyBasics());
						l_ObjOnboardDTO.setNewMachineRequest(
								nmDetail.getNewMachineRequest() == null ? null : nmDetail.getNewMachineRequest());
						l_ObjOnboardDTO.setSignOnForm(nmDetail.getSignOnForm() == null ? null : nmDetail.getSignOnForm());
						l_ObjOnboardDTO.setPpmForm(nmDetail.getPpmForm() == null ? null : nmDetail.getPpmForm());
						l_ObjOnboardDTO.setNdaForm(nmDetail.getNdaForm() == null ? null : nmDetail.getNdaForm());
						l_ObjOnboardDTO.setNmDrugTestReRaised(
								nmDetail.getNmDrugTestReRaised() == null ? null : nmDetail.getNmDrugTestReRaised());
						l_ObjOnboardDTO.setNmIntroductionTraining(nmDetail.getNmIntroductionTraining() == null ? null
								: nmDetail.getNmIntroductionTraining());
						l_ObjOnboardDTO.setNmDLUpdate(nmDetail.getNmDLUpdate() == null ? null : nmDetail.getNmDLUpdate());
						l_ObjOnboardDTO.setNmDrugTest(nmDetail.getNmDrugTest() == null ? null : nmDetail.getNmDrugTest());
						l_ObjOnboardDTO.setProdTermId(nmDetail.getProdTermId() == null ? null : nmDetail.getProdTermId());
					}
					l_lstResult.add(l_ObjOnboardDTO);
				}
			}
			return l_lstResult;
		} catch (Exception p_objEx) {
			p_objEx.getMessage();
		}
		return l_lstResult;
	}
	
	public String getLocationPOC(int Location_ID) {
		List<Map<String, Object>> m_lstData = null;
		String locationPOC= null;
		try {
			Map<String, Object> l_mapAttributes = new HashMap<String, Object>();
			l_mapAttributes.put("LOCATION_ID", Location_ID);
			m_lstData = m_objNamedParameterJdbcTemplate
					.queryForList(getPropValuesForQuery().getProperty("getLocationPOC"), l_mapAttributes);
			if (m_lstData != null){
				for (Map<String, Object> map : m_lstData) {
					locationPOC = map.get("LOCATION_PDL").toString();
				}
			}
		} catch (Exception p_objEx) {
			p_objEx.getMessage();
		}
		return locationPOC;
	}

	@Override
	public List<String> getDirectors() {
		List<String> m_objData = null;
		String query = "SELECT USER_VALUE FROM NM_CONFIG WHERE USER_KEY = :DIRECTORS";
		try {
			Map<String, Object> l_mapAttributes = new HashMap<String, Object>();
			l_mapAttributes.put("DIRECTORS", NMConstants.NM_DIRECTORS);

			m_objData = m_objNamedParameterJdbcTemplate.queryForList(query, l_mapAttributes, String.class);
			System.out.println("InSide getDirectors m_objData: " + m_objData);
		} catch (Exception p_objEx) {
			p_objEx.getMessage();
			System.out.println("getDirectors Exception" + p_objEx.getMessage());
		}
		return m_objData;
	}

	@Override
	public List<String> getAnchors() {
		List<String> m_objData = null;
		String query = "SELECT USER_VALUE FROM NM_CONFIG WHERE USER_KEY = :ANCHORS";
		try {
			Map<String, Object> l_mapAttributes = new HashMap<String, Object>();
			l_mapAttributes.put("ANCHORS", NMConstants.NM_ANCHORS);

			m_objData = m_objNamedParameterJdbcTemplate.queryForList(query, l_mapAttributes, String.class);
			System.out.println("InSide getDirectors m_objData: " + m_objData);
		} catch (Exception p_objEx) {
			p_objEx.getMessage();
			System.out.println("getDirectors Exception" + p_objEx.getMessage());
		}
		return m_objData;
	}
	
	

	/*public List<Map<String, Object>> getNmDetails() {
		List<Map<String, Object>> m_lstData = null;
		String query = "SELECT NM_ADDITIONAL_DETAILS FROM NM_WORKFLOW_DETAILS where FIRST_NAME = 'NmUser'";
		try {
			Map<String, Object> l_mapAttributes = new HashMap<String, Object>();
			m_lstData = m_objNamedParameterJdbcTemplate.queryForList(query, l_mapAttributes);
			String retrieveXmlAsString = null;
			System.out.println("m_lstData" + m_lstData.toString());
			if (m_lstData != null) {
				for (Map<String, Object> m_lstDataTemp : m_lstData) {
					retrieveXmlAsString = m_lstDataTemp.get("NM_ADDITIONAL_DETAILS").toString();
					System.out.println("nmDetails: " + retrieveXmlAsString);
				}
				java.io.FileWriter fw = new java.io.FileWriter("D:/735081/NM_ON-Board_Doc/my-file.xml");
				fw.write(retrieveXmlAsString.toString());
				fw.close();

				DocumentBuilderFactory fctr = DocumentBuilderFactory.newInstance();
				DocumentBuilder bldr = fctr.newDocumentBuilder();
				InputSource insrc = new InputSource(new StringReader(retrieveXmlAsString));
				bldr.parse(insrc);
			}

		} catch (Exception p_objEx) {
			p_objEx.getMessage();
		}
		return m_lstData;
	}*/

	/*
	 * public void testNmDetails() { try { blobUtil.setNmDetails();
	 * 
	 * String query =
	 * "UPDATE NM_WORKFLOW_DETAILS SET NM_DETAILS = :NM_DETAILS WHERE FIRST_NAME='Nanda'"
	 * ; String msg = "success"; File file = new
	 * File("C:/Users/735081/Desktop/NMJML/BlobTestFiles/Source/Blobfile.xml");
	 * 
	 * FileInputStream input = new FileInputStream(file); Map<String, Object>
	 * l_mapAttributes = new HashMap<String, Object>();
	 * l_mapAttributes.put("NM_DETAILS", input);
	 * 
	 * int m_lstData = m_objNamedParameterJdbcTemplate.update(query,
	 * l_mapAttributes); } catch (Exception p_objEx) { p_objEx.getMessage(); } }
	 */

}
