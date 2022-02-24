package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.VenueScheduleModel;

public class VenueScheduleMapper implements RowMapper<VenueScheduleModel> {

	@Override
	public VenueScheduleModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		VenueScheduleModel model = new VenueScheduleModel();
		model.setVenueId("v_" + String.valueOf(resultSet.getInt("venueId")));
		model.setVenueName(resultSet.getString("venueName"));
		model.setVenueType(resultSet.getString("venueType"));
		model.setVenueDescription(resultSet.getString("venueDesc"));
		model.setPhotoName("https://partyplanning.s3.ap-south-1.amazonaws.com/" + resultSet.getString("photoName"));

		model.setVenueId("v_" + String.valueOf(resultSet.getInt("venueId")));
		model.setScheduleId("s_" + String.valueOf(resultSet.getInt("scheduleId")));
		model.setStartDate(resultSet.getDate("startDate"));
		model.setEndDate(resultSet.getDate("endDate"));

		model.setFacilities(resultSet.getString("facilities"));
		model.setMaxCapacity(resultSet.getInt("maxCapacity"));
		model.setPrice(resultSet.getDouble("price"));
		return model;
	}

}
