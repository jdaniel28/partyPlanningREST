package com.party.partymangement.model;

public class InviteeModel {

	/** The invitee id. */
	private int inviteeId;
	private int bookingId;
	private int contactId;

	/** The greeting id. */
	private String greetingId;

	public int getInviteeId() {
		return inviteeId;
	}

	public void setInviteeId(int inviteeId) {
		this.inviteeId = inviteeId;
	}

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

	public String getGreetingId() {
		return greetingId;
	}

	public void setGreetingId(String greetingId) {
		this.greetingId = greetingId;
	}

}
