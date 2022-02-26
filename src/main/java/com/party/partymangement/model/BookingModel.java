package com.party.partymangement.model;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingModel.
 */
public class BookingModel {

	/** The booking id. */
	private int bookingId;

	/** The user id. */
	private String userId;

	/** The schedule id. */
	private String scheduleId;

	/** The num seats. */
	private int numSeats;

	/**
	 * Gets the num seats.
	 *
	 * @return the num seats
	 */
	public int getNumSeats() {
		return numSeats;
	}

	/**
	 * Sets the num seats.
	 *
	 * @param numSeats the new num seats
	 */
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
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
	 * Instantiates a new booking model.
	 *
	 * @param bookingId  the booking id
	 * @param userId     the user id
	 * @param scheduleId the schedule id
	 * @param numSeats   the num seats
	 */
	public BookingModel(int bookingId, String userId, String scheduleId, int numSeats) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.scheduleId = scheduleId;
		this.numSeats = numSeats;
	}

	/**
	 * Instantiates a new booking model.
	 */
	public BookingModel() {
		super();
	}

}
