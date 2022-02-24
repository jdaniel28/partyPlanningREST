package com.party.partymangement.model;

public class FeedbackModel {
	
	private String feedbackId;
	private String userId;
	private String venueId;
	private String ans1;
	private String ans2;
	private String ans3;
	private String rating;
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
	public String getVenueId() {
		return venueId;
	}
	public void setVenueId(String venueId) {
		this.venueId = venueId;
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
	public FeedbackModel(String feedbackId, String userId, String venueId, String ans1, String ans2, String ans3,
			String rating) {
		super();
		this.feedbackId = feedbackId;
		this.userId = userId;
		this.venueId = venueId;
		this.ans1 = ans1;
		this.ans2 = ans2;
		this.ans3 = ans3;
		this.rating = rating;
	}
	public FeedbackModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FeedbackModel [feedbackId=" + feedbackId + ", userId=" + userId + ", venueId=" + venueId + ", ans1="
				+ ans1 + ", ans2=" + ans2 + ", ans3=" + ans3 + ", rating=" + rating + "]";
	}
	
	
	
	
	
	
}