package com.party.partymangement.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.party.partymangement.model.VenueModel;

public class VenueMapper implements RowMapper<VenueModel> {
	
	@Override
	public VenueModel mapRow(ResultSet resultSet, int i) throws SQLException {
		
		VenueModel venue = new VenueModel();
		venue.setVenueId(resultSet.getString("venueId"));
		venue.setVenueName(resultSet.getString("venueName"));
		venue.setVenueType(resultSet.getString("venueType"));
		return venue;

}
}
