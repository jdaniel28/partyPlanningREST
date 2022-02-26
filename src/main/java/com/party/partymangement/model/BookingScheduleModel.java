package com.party.partymangement.model;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingScheduleModel.
 */
public class BookingScheduleModel {

	/** The booking id. */
	private int bookingId;

	/** The user id. */
	private String userId;

	/** The schedule id. */
	private String scheduleId;

	/** The start date. */
	private Date startDate;

	/** The end date. */
	private Date endDate;

	/** The price. */
	private double price;

	/**
	 * Instantiates a new booking schedule model.
	 */
	public BookingScheduleModel() {
		super();
	}

	/**
	 * Instantiates a new booking schedule model.
	 *
	 * @param bookingId  the booking id
	 * @param userId     the user id
	 * @param scheduleId the schedule id
	 * @param startDate  the start date
	 * @param endDate    the end date
	 * @param price      the price
	 */
	public BookingScheduleModel(int bookingId, String userId, String scheduleId, Date startDate, Date endDate,
			double price) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.scheduleId = scheduleId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
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
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
