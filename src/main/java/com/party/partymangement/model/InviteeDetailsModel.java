package com.party.partymangement.model;

public class InviteeDetailsModel {

	private int bookingId;
	private int contactId;
	private String photoName;
	private String inviteText;
	private String name;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getInviteText() {
		return inviteText;
	}

	public void setInviteText(String inviteText) {
		this.inviteText = inviteText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
