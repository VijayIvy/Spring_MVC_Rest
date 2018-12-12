package com.cts.nm.model;

public class MailDetails {

	private String toMail;

	private String msgSubject;

	private String msgBody;
	
	private String toCc;

	public String getToCc() {
		return toCc;
	}

	public void setToCc(String toCc) {
		this.toCc = toCc;
	}

	public String getToMail() {
		return toMail;
	}

	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

	public String getMsgSubject() {
		return msgSubject;
	}

	public void setMsgSubject(String msgSubject) {
		this.msgSubject = msgSubject;
	}

	public String getMsgBody() {
		return msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

}
