package com.party.partymangement.model;

// TODO: Auto-generated Javadoc
/**
 * The Class InviteeDetailsModel.
 */
public class InviteeDetailsModel {

	/** The booking id. */
	private int bookingId;

	/** The contact id. */
	private int contactId;

	/** The photo name. */
	private String photoName;

	/** The invite text. */
	private String inviteText;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new invitee details model.
	 */
	public InviteeDetailsModel() {
		super();
	}

	/**
	 * Instantiates a new invitee details model.
	 *
	 * @param bookingId  the booking id
	 * @param contactId  the contact id
	 * @param inviteText the invite text
	 * @param name       the name
	 */
	public InviteeDetailsModel(int bookingId, int contactId, String inviteText, String name) {
		super();
		this.bookingId = bookingId;
		this.contactId = contactId;
		this.inviteText = inviteText;
		this.name = name;
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
	 * Gets the photo name.
	 *
	 * @return the photo name
	 */
	public String getPhotoName() {
		return photoName;
	}

	/**
	 * Sets the photo name.
	 *
	 * @param photoName the new photo name
	 */
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	/**
	 * Gets the invite text.
	 *
	 * @return the invite text
	 */
	public String getInviteText() {
		return inviteText;
	}

	/**
	 * Sets the invite text.
	 *
	 * @param inviteText the new invite text
	 */
	public void setInviteText(String inviteText) {
		this.inviteText = inviteText;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
