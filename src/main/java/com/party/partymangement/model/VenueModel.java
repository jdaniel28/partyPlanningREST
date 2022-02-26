package com.party.partymangement.model;

// TODO: Auto-generated Javadoc
/**
 * The Class VenueModel.
 */
public class VenueModel {

	/** The venue id. */
	private String venueId;

	/** The venue name. */
	private String venueName;

	/** The venue description. */
	private String venueDescription;

	/** The venue type. */
	private String venueType;

	/** The photo name. */
	private String photoName;

	/**
	 * Instantiates a new venue model.
	 *
	 * @param venueId          the venue id
	 * @param venueName        the venue name
	 * @param venueDescription the venue description
	 * @param venueType        the venue type
	 */
	public VenueModel(String venueId, String venueName, String venueDescription, String venueType) {
		super();
		this.venueId = venueId;
		this.venueName = venueName;
		this.venueDescription = venueDescription;
		this.venueType = venueType;
	}

	/**
	 * Gets the venue description.
	 *
	 * @return the venue description
	 */
	public String getVenueDescription() {
		return venueDescription;
	}

	/**
	 * Sets the venue description.
	 *
	 * @param venueDescription the new venue description
	 */
	public void setVenueDescription(String venueDescription) {
		this.venueDescription = venueDescription;
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
	 * Instantiates a new venue model.
	 */
	public VenueModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new venue model.
	 *
	 * @param venueId   the venue id
	 * @param venueName the venue name
	 * @param venueType the venue type
	 */
	public VenueModel(String venueId, String venueName, String venueType) {
		super();
		this.venueId = venueId;
		this.venueName = venueName;
		this.venueType = venueType;
	}

	/**
	 * Gets the venue id.
	 *
	 * @return the venue id
	 */
	public String getVenueId() {
		return venueId;
	}

	/**
	 * Sets the venue id.
	 *
	 * @param venueId the new venue id
	 */
	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}

	/**
	 * Gets the venue name.
	 *
	 * @return the venue name
	 */
	public String getVenueName() {
		return venueName;
	}

	/**
	 * Sets the venue name.
	 *
	 * @param venueName the new venue name
	 */
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	/**
	 * Gets the venue type.
	 *
	 * @return the venue type
	 */
	public String getVenueType() {
		return venueType;
	}

	/**
	 * Sets the venue type.
	 *
	 * @param venueType the new venue type
	 */
	public void setVenueType(String venueType) {
		this.venueType = venueType;
	}

}
