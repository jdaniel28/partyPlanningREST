package com.party.partymangement.model;



public class VenueModel {

	private String venueId;
	private String venueName;
	private String venueType;
	
	
	
	public VenueModel() {
		super();
		// TODO Auto-generated constructor stub
	}



	public VenueModel(String venueId, String venueName, String venueType) {
		super();
		this.venueId = venueId;
		this.venueName = venueName;
		this.venueType = venueType;
	}



	public String getVenueId() {
		return venueId;
	}



	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}



	public String getVenueName() {
		return venueName;
	}



	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}



	public String getVenueType() {
		return venueType;
	}



	public void setVenueType(String venueType) {
		this.venueType = venueType;
	}
	
	
	
	
}