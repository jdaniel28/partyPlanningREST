package com.party.partymangement.model;

public class FeedbackWithQuestionsModel {
	private int qId;
	private String ques1;
	private String ques2;
	private String ques3;
	private String feedbackId;
	private String userId;
	private int bookingId;
	private String ans1;
	private String ans2;
	private String ans3;
	private String rating;

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getQues1() {
		return ques1;
	}

	public void setQues1(String ques1) {
		this.ques1 = ques1;
	}

	public String getQues2() {
		return ques2;
	}

	public void setQues2(String ques2) {
		this.ques2 = ques2;
	}

	public String getQues3() {
		return ques3;
	}

	public void setQues3(String ques3) {
		this.ques3 = ques3;
	}

	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
}
