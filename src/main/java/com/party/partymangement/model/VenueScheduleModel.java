package com.party.partymangement.model;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class VenueScheduleModel.
 */
public class VenueScheduleModel {

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

	/** The schedule id. */
	private String scheduleId;

	/** The start date. */
	private Date startDate;

	/** The end date. */
	private Date endDate;

	/** The facilities. */
	private String facilities;

	/** The max capacity. */
	private int maxCapacity;

	/** The price. */
	private double price;

	/**
	 * Instantiates a new venue schedule model.
	 */
	public VenueScheduleModel() {
		super();
	}

	/**
	 * Instantiates a new venue schedule model.
	 *
	 * @param venueId          the venue id
	 * @param venueName        the venue name
	 * @param venueDescription the venue description
	 * @param venueType        the venue type
	 * @param scheduleId       the schedule id
	 * @param startDate        the start date
	 * @param endDate          the end date
	 * @param facilities       the facilities
	 * @param maxCapacity      the max capacity
	 * @param price            the price
	 */
	public VenueScheduleModel(String venueId, String venueName, String venueDescription, String venueType,
			String scheduleId, Date startDate, Date endDate, String facilities, int maxCapacity, double price) {
		super();
		this.venueId = venueId;
		this.venueName = venueName;
		this.venueDescription = venueDescription;
		this.venueType = venueType;
		this.scheduleId = scheduleId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.facilities = facilities;
		this.maxCapacity = maxCapacity;
		this.price = price;
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
	 * Gets the schedule id.
	 *
	 * @return the schedule id
	 */
	public String getScheduleId() {
		return scheduleId;
	}

	/**
	 * Sets the schedule id.
	 *
	 * @param scheduleId the new schedule id
	 */
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the facilities.
	 *
	 * @return the facilities
	 */
	public String getFacilities() {
		return facilities;
	}

	/**
	 * Sets the facilities.
	 *
	 * @param facilities the new facilities
	 */
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	/**
	 * Gets the max capacity.
	 *
	 * @return the max capacity
	 */
	public int getMaxCapacity() {
		return maxCapacity;
	}

	/**
	 * Sets the max capacity.
	 *
	 * @param maxCapacity the new max capacity
	 */
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
