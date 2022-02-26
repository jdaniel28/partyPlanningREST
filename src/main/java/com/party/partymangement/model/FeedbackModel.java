package com.party.partymangement.model;

// TODO: Auto-generated Javadoc
/**
 * The Class FeedbackModel.
 */
public class FeedbackModel {

	/** The feedback id. */
	private String feedbackId;

	/** The user id. */
	private String userId;

	/** The booking id. */
	private int bookingId;

	/** The ans 1. */
	private String ans1;

	/** The ans 2. */
	private String ans2;

	/** The ans 3. */
	private String ans3;

	/** The rating. */
	private String rating;

	/** The q id. */
	private int qId;

	/**
	 * Instantiates a new feedback model.
	 *
	 * @param feedbackId the feedback id
	 * @param userId     the user id
	 * @param bookingId  the booking id
	 * @param ans1       the ans 1
	 * @param ans2       the ans 2
	 * @param ans3       the ans 3
	 * @param rating     the rating
	 * @param qId        the q id
	 */
	public FeedbackModel(String feedbackId, String userId, int bookingId, String ans1, String ans2, String ans3,
			String rating, int qId) {
		super();
		this.feedbackId = feedbackId;
		this.userId = userId;
		this.bookingId = bookingId;
		this.ans1 = ans1;
		this.ans2 = ans2;
		this.ans3 = ans3;
		this.rating = rating;
		this.qId = qId;
	}

	/**
	 * Gets the q id.
	 *
	 * @return the q id
	 */
	public int getqId() {
		return qId;
	}

	/**
	 * Sets the q id.
	 *
	 * @param qId the new q id
	 */
	public void setqId(int qId) {
		this.qId = qId;
	}

	/**
	 * Gets the feedback id.
	 *
	 * @return the feedback id
	 */
	public String getFeedbackId() {
		return feedbackId;
	}

	/**
	 * Sets the feedback id.
	 *
	 * @param feedbackId the new feedback id
	 */
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
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
	 * Gets the ans 1.
	 *
	 * @return the ans 1
	 */
	public String getAns1() {
		return ans1;
	}

	/**
	 * Sets the ans 1.
	 *
	 * @param ans1 the new ans 1
	 */
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	/**
	 * Gets the ans 2.
	 *
	 * @return the ans 2
	 */
	public String getAns2() {
		return ans2;
	}

	/**
	 * Sets the ans 2.
	 *
	 * @param ans2 the new ans 2
	 */
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	/**
	 * Gets the ans 3.
	 *
	 * @return the ans 3
	 */
	public String getAns3() {
		return ans3;
	}

	/**
	 * Sets the ans 3.
	 *
	 * @param ans3 the new ans 3
	 */
	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * Instantiates a new feedback model.
	 */
	public FeedbackModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}