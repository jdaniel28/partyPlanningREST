package com.party.partymangement.model;

// TODO: Auto-generated Javadoc
/**
 * The Class InviteModel.
 */
public class InviteModel {

	/** The invite id. */
	private String greetingId;

	/** The photo name. */
	private String photoName;

	/** The invite text. */
	private String inviteText;

	public InviteModel(String greetingId, String photoName, String inviteText) {
		super();
		this.greetingId = greetingId;
		this.photoName = photoName;
		this.inviteText = inviteText;
	}

	public InviteModel() {
		super();
	}

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

}
