package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.VenueModel;

public class VenueMapper implements RowMapper<VenueModel> {

	@Override
	public VenueModel mapRow(ResultSet resultSet, int i) throws SQLException {

		VenueModel venue = new VenueModel();
		venue.setVenueId("v_" + String.valueOf(resultSet.getInt("venueId")));
		venue.setVenueName(resultSet.getString("venueName"));
		venue.setVenueType(resultSet.getString("venueType"));
		venue.setVenueDescription(resultSet.getString("venueDesc"));
		venue.setPhotoName("https://partyplanning.s3.ap-south-1.amazonaws.com/" + resultSet.getString("photoName"));
		return venue;

	}
}