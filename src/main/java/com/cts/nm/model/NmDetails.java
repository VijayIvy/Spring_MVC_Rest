package com.cts.nm.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="NmDetails")
public class NmDetails {
	int nmDetailid;
	
	public int getNmDetailId() {
		return nmDetailid;
	}
	@XmlAttribute
	public void setNmDetailId(int nmDetailid) {
		this.nmDetailid = nmDetailid;
	}
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

	public String getBuildingAccesRequest() {
		return buildingAccesRequest;
	}
	
	@XmlElement
	public void setBuildingAccesRequest(String buildingAccesRequest) {
		this.buildingAccesRequest = buildingAccesRequest;
	}
	public String getMutualCodeOfConduct() {
		return mutualCodeOfConduct;
	}
	
	@XmlElement
	public void setMutualCodeOfConduct(String mutualCodeOfConduct) {
		this.mutualCodeOfConduct = mutualCodeOfConduct;
	}
	public String getDrugTestException() {
		return drugTestException;
	}
	
	@XmlElement
	public void setDrugTestException(String drugTestException) {
		this.drugTestException = drugTestException;
	}
	public String getPrivacyBasics() {
		return privacyBasics;
	}
	
	@XmlElement
	public void setPrivacyBasics(String privacyBasics) {
		this.privacyBasics = privacyBasics;
	}
	public String getNewMachineRequest() {
		return newMachineRequest;
	}
	
	@XmlElement
	public void setNewMachineRequest(String newMachineRequest) {
		this.newMachineRequest = newMachineRequest;
	}
	public String getSignOnForm() {
		return signOnForm;
	}
	
	@XmlElement
	public void setSignOnForm(String signOnForm) {
		this.signOnForm = signOnForm;
	}
	public String getPpmForm() {
		return ppmForm;
	}
	
	@XmlElement
	public void setPpmForm(String ppmForm) {
		this.ppmForm = ppmForm;
	}
	public String getNdaForm() {
		return ndaForm;
	}
	
	@XmlElement
	public void setNdaForm(String ndaForm) {
		this.ndaForm = ndaForm;
	}
	public String getNmDrugTestReRaised() {
		return nmDrugTestReRaised;
	}
	
	@XmlElement
	public void setNmDrugTestReRaised(String nmDrugTestReRaised) {
		this.nmDrugTestReRaised = nmDrugTestReRaised;
	}
	public String getNmIntroductionTraining() {
		return nmIntroductionTraining;
	}
	
	@XmlElement
	public void setNmIntroductionTraining(String nmIntroductionTraining) {
		this.nmIntroductionTraining = nmIntroductionTraining;
	}
	public String getNmDLUpdate() {
		return nmDLUpdate;
	}
	
	@XmlElement
	public void setNmDLUpdate(String nmDLUpdate) {
		this.nmDLUpdate = nmDLUpdate;
	}
	public String getNmDrugTest() {
		return nmDrugTest;
	}
	
	@XmlElement
	public void setNmDrugTest(String nmDrugTest) {
		this.nmDrugTest = nmDrugTest;
	}
	public String getProdTermId() {
		return prodTermId;
	}
	
	@XmlElement
	public void setProdTermId(String prodTermId) {
		this.prodTermId = prodTermId;
	}
	
	
	
	
	/*
	 * String firstname;
	String lastname;
	String nickname;
	String salary; 
	 * 
	 * public String getFirstname() {
	return firstname;
}
@XmlElement
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
@XmlElement
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getNickname() {
	return nickname;
}
@XmlElement
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getSalary() {
	return salary;
}
@XmlElement
public void setSalary(String salary) {
	this.salary = salary;
}*/
	
}
