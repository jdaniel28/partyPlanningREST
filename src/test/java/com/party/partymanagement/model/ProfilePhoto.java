package com.party.partymanagement.model;

import org.springframework.web.multipart.MultipartFile;

public class ProfilePhoto {

	private MultipartFile photo;
	private String userId;

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
