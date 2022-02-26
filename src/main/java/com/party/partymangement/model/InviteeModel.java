package com.party.partymangement.model;

// TODO: Auto-generated Javadoc
/**
 * The Class InviteeModel.
 */
public class InviteeModel {

	/** The invitee id. */
	private int inviteeId;

	/** The booking id. */
	private int bookingId;

	/** The contact id. */
	private int contactId;

	/** The greeting id. */
	private String greetingId;

	public InviteeModel() {
		super();
	}

	public InviteeModel(int inviteeId, int bookingId, int contactId, String greetingId) {
		super();
		this.inviteeId = inviteeId;
		this.bookingId = bookingId;
		this.contactId = contactId;
		this.greetingId = greetingId;
	}

	/**
	 * Gets the invitee id.
	 *
	 * @return the invitee id
	 */
	public int getInviteeId() {
		return inviteeId;
	}

	/**
	 * Sets the invitee id.
	 *
	 * @param inviteeId the new invitee id
	 */
	public void setInviteeId(int inviteeId) {
		this.inviteeId = inviteeId;
	}

	/**
	 * Gets the booking id.
	 *
	 * @return the booking id
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * Sets the booking id.
	 *
	 * @param bookingId the new booking id
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * Gets the contact id.
	 *
	 * @return the contact id
	 */
	public int getContactId() {
		return contactId;
	}

	/**
	 * Sets the contact id.
	 *
	 * @param contactId the new contact id
	 */
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	/**
	 * Gets the greeting id.
	 *
	 * @return the greeting id
	 */
	public String getGreetingId() {
		return greetingId;
	}

	/**
	 * Sets the greeting id.
	 *
	 * @param greetingId the new greeting id
	 */
	public void setGreetingId(String greetingId) {
		this.greetingId = greetingId;
	}

}
