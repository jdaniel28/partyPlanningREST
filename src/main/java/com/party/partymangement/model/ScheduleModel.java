package com.party.partymangement.model;

import java.util.Date;

public class ScheduleModel {

	private String venueId;
	private String scheduleId;
	private Date startDate;
	private Date endDate;
	private String facilities;
	private int maxCapacity;
	private double price;
	
	
	
	
	public ScheduleModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ScheduleModel(String venueId, String scheduleId, Date startDate, Date endDate, String facilities,
			int maxCapacity, double price) {
		super();
		this.venueId = venueId;
		this.scheduleId = scheduleId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.facilities = facilities;
		this.maxCapacity = maxCapacity;
		this.price = price;
	}



	public String getVenueId() {
		return venueId;
	}
	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}