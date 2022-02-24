package com.party.partymangement.model;

public class UserContactModel {

	private int contactId;
	private String userId;
	private String name;
	private String contactNumber;
	private String email;
	public UserContactModel(int contactId, String userId, String name, String contactNumber, String email) {
		super();
		this.contactId = contactId;
		this.userId = userId;
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
	}
	public UserContactModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserContactModel [contactId=" + contactId + ", userId=" + userId + ", name=" + name + ", contactNumber="
				+ contactNumber + ", email=" + email + "]";
	}
	
	 
	
}
