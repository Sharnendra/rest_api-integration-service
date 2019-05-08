package com.service.integration.request;

public class UserDetailsInfo {

	private String name;
	private String phoneNumber;
	private String emailId;
	private String phoneOTP;
	private String emailOTP;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneOTP() {
		return phoneOTP;
	}
	public void setPhoneOTP(String phoneOTP) {
		this.phoneOTP = phoneOTP;
	}
	public String getEmailOTP() {
		return emailOTP;
	}
	public void setEmailOTP(String emailOTP) {
		this.emailOTP = emailOTP;
	}
	@Override
	public String toString() {
		return "UserDetailsInfo [name=" + name + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", phoneOTP="
				+ phoneOTP + ", emailOTP=" + emailOTP + "]";
	}
	
	
}
