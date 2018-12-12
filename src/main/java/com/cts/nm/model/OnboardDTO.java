package com.cts.nm.model;

import java.sql.Blob;

import javax.xml.bind.annotation.XmlAttribute;

public class OnboardDTO {

	private String userName;
	private int userRole;
	private int workFlowId;
	private String firstName;
	private String lastName;
	private int ctsEmpId;
	private String ctsEmailId;
	private String onBoardStatus;
	private String onBoardCoordinator;
	private String projectName;
	private String ctsJoinDate;
	private String nmJoinDate;
	private String nmEndDate;
	private String teamName;
	private String location;
	private int locationId;
	private String projectRole;
	private String unit;
	private String subUnit;
	private String directors;
	private String anchors;
	private String nmProjectType;
	private String nmSow;
	private String nmLanId;
	private String nmIsManager;
	private String classification;
	private String reason;
	private String assignTo;
	private String nmOffBoardStatus;
	private String nmOffBoardCoordinator;
	private String updatedDate;
	private String lastUpdatedDate;
	private String nmAdditionalDetails;
	
	private String buildingAccesRequest;
	private String mutualCodeOfConduct;
	private String drugTestException;
	private String privacyBasics;
	private String newMachineRequest;
	private String signOnForm;
	private String ppmForm;
	private String ndaForm;
	private String nmDrugTestReRaised;
	private String nmIntroductionTraining;
	private String nmDLUpdate;
	private String nmDrugTest;
	private String prodTermId;
	int nmDetailid;
	private String m_sSearch;
	public int getNmDetailId() {
		return nmDetailid;
	}
	public void setNmDetailId(int nmDetailid) {
		this.nmDetailid = nmDetailid;
	}
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public int getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(int workFlowId) {
		this.workFlowId = workFlowId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCtsEmpId() {
		return ctsEmpId;
	}

	public void setCtsEmpId(int ctsEmpId) {
		this.ctsEmpId = ctsEmpId;
	}

	public String getCtsEmailId() {
		return ctsEmailId;
	}

	public void setCtsEmailId(String ctsEmailId) {
		this.ctsEmailId = ctsEmailId;
	}

	public String getOnBoardStatus() {
		return onBoardStatus;
	}

	public void setOnBoardStatus(String onBoardStatus) {
		this.onBoardStatus = onBoardStatus;
	}

	public String getOnBoardCoordinator() {
		return onBoardCoordinator;
	}

	public void setOnBoardCoordinator(String onBoardCoordinator) {
		this.onBoardCoordinator = onBoardCoordinator;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCtsJoinDate() {
		return ctsJoinDate;
	}

	public void setCtsJoinDate(String ctsJoinDate) {
		this.ctsJoinDate = ctsJoinDate;
	}

	public String getNmJoinDate() {
		return nmJoinDate;
	}

	public void setNmJoinDate(String nmJoinDate) {
		this.nmJoinDate = nmJoinDate;
	}

	public String getNmEndDate() {
		return nmEndDate;
	}

	public void setNmEndDate(String nmEndDate) {
		this.nmEndDate = nmEndDate;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getProjectRole() {
		return projectRole;
	}

	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSubUnit() {
		return subUnit;
	}

	public void setSubUnit(String subUnit) {
		this.subUnit = subUnit;
	}

	public String getDirectors() {
		return directors;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public String getAnchors() {
		return anchors;
	}

	public void setAnchors(String anchors) {
		this.anchors = anchors;
	}

	public String getNmProjectType() {
		return nmProjectType;
	}

	public void setNmProjectType(String nmProjectType) {
		this.nmProjectType = nmProjectType;
	}

	public String getNmSow() {
		return nmSow;
	}

	public void setNmSow(String nmSow) {
		this.nmSow = nmSow;
	}

	public String getNmLanId() {
		return nmLanId;
	}

	public void setNmLanId(String nmLanId) {
		this.nmLanId = nmLanId;
	}

	public String getNmIsManager() {
		return nmIsManager;
	}

	public void setNmIsManager(String nmIsManager) {
		this.nmIsManager = nmIsManager;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	public String getNmOffBoardStatus() {
		return nmOffBoardStatus;
	}

	public void setNmOffBoardStatus(String nmOffBoardStatus) {
		this.nmOffBoardStatus = nmOffBoardStatus;
	}

	public String getNmOffBoardCoordinator() {
		return nmOffBoardCoordinator;
	}

	public void setNmOffBoardCoordinator(String nmOffBoardCoordinator) {
		this.nmOffBoardCoordinator = nmOffBoardCoordinator;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getNmAdditionalDetails() {
		return nmAdditionalDetails;
	}

	public void setNmAdditionalDetails(String nmAdditionalDetails) {
		this.nmAdditionalDetails = nmAdditionalDetails;
	}

	public String getBuildingAccesRequest() {
		return buildingAccesRequest;
	}

	public void setBuildingAccesRequest(String buildingAccesRequest) {
		this.buildingAccesRequest = buildingAccesRequest;
	}

	public String getMutualCodeOfConduct() {
		return mutualCodeOfConduct;
	}

	public void setMutualCodeOfConduct(String mutualCodeOfConduct) {
		this.mutualCodeOfConduct = mutualCodeOfConduct;
	}

	public String getDrugTestException() {
		return drugTestException;
	}

	public void setDrugTestException(String drugTestException) {
		this.drugTestException = drugTestException;
	}

	public String getPrivacyBasics() {
		return privacyBasics;
	}

	public void setPrivacyBasics(String privacyBasics) {
		this.privacyBasics = privacyBasics;
	}

	public String getNewMachineRequest() {
		return newMachineRequest;
	}

	public void setNewMachineRequest(String newMachineRequest) {
		this.newMachineRequest = newMachineRequest;
	}

	public String getSignOnForm() {
		return signOnForm;
	}

	public void setSignOnForm(String signOnForm) {
		this.signOnForm = signOnForm;
	}

	public String getPpmForm() {
		return ppmForm;
	}

	public void setPpmForm(String ppmForm) {
		this.ppmForm = ppmForm;
	}

	public String getNdaForm() {
		return ndaForm;
	}

	public void setNdaForm(String ndaForm) {
		this.ndaForm = ndaForm;
	}

	public String getNmDrugTestReRaised() {
		return nmDrugTestReRaised;
	}

	public void setNmDrugTestReRaised(String nmDrugTestReRaised) {
		this.nmDrugTestReRaised = nmDrugTestReRaised;
	}

	public String getNmIntroductionTraining() {
		return nmIntroductionTraining;
	}

	public void setNmIntroductionTraining(String nmIntroductionTraining) {
		this.nmIntroductionTraining = nmIntroductionTraining;
	}

	public String getNmDLUpdate() {
		return nmDLUpdate;
	}

	public void setNmDLUpdate(String nmDLUpdate) {
		this.nmDLUpdate = nmDLUpdate;
	}

	public String getNmDrugTest() {
		return nmDrugTest;
	}

	public void setNmDrugTest(String nmDrugTest) {
		this.nmDrugTest = nmDrugTest;
	}

	public String getProdTermId() {
		return prodTermId;
	}

	public void setProdTermId(String prodTermId) {
		this.prodTermId = prodTermId;
	}
	
	public String getSearch() {
		return m_sSearch;
	}

	public void setSearch(String p_sSearch) {
		this.m_sSearch = p_sSearch;
	}
	@Override
	public String toString() {
		return "OnboardDTO [userName=" + userName + ", userRole=" + userRole + ", workFlowId=" + workFlowId
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", ctsEmpId=" + ctsEmpId + ", ctsEmailId="
				+ ctsEmailId + ", onBoardStatus=" + onBoardStatus + ", onBoardCoordinator=" + onBoardCoordinator
				+ ", projectName=" + projectName + ", ctsJoinDate=" + ctsJoinDate + ", nmJoinDate=" + nmJoinDate
				+ ", nmEndDate=" + nmEndDate + ", teamName=" + teamName + ", location=" + location + ", locationId="
				+ locationId + ", projectRole=" + projectRole + ", unit=" + unit + ", subUnit=" + subUnit
				+ ", directors=" + directors + ", anchors=" + anchors + ", nmProjectType=" + nmProjectType + ", nmSow="
				+ nmSow + ", nmLanId=" + nmLanId + ", nmIsManager=" + nmIsManager + ", classification=" + classification
				+ ", reason=" + reason + ", assignTo=" + assignTo + ", nmOffBoardStatus=" + nmOffBoardStatus
				+ ", nmOffBoardCoordinator=" + nmOffBoardCoordinator + ", updatedDate=" + updatedDate
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", nmAdditionalDetails=" + nmAdditionalDetails
				+ ", buildingAccesRequest=" + buildingAccesRequest + ", mutualCodeOfConduct=" + mutualCodeOfConduct
				+ ", drugTestException=" + drugTestException + ", privacyBasics=" + privacyBasics
				+ ", newMachineRequest=" + newMachineRequest + ", signOnForm=" + signOnForm + ", ppmForm=" + ppmForm
				+ ", ndaForm=" + ndaForm + ", nmDrugTestReRaised=" + nmDrugTestReRaised + ", nmIntroductionTraining="
				+ nmIntroductionTraining + ", nmDLUpdate=" + nmDLUpdate + ", nmDrugTest=" + nmDrugTest + ", prodTermId="
				+ prodTermId + "]";
	}
}
