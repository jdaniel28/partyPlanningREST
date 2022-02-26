package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.VenueModel;

// TODO: Auto-generated Javadoc
/**
 * The Class VenueMapper.
 */
public class VenueMapper implements RowMapper<VenueModel> {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(VenueMapper.class);

	/**
	 * Map row.
	 *
	 * @param resultSet the result set
	 * @param i         the i
	 * @return the venue model
	 * @throws SQLException the SQL exception
	 */
	@Override
	public VenueModel mapRow(ResultSet resultSet, int i) throws SQLException {
		LOGGER.info("Start - venueMapper");
		VenueModel venue = new VenueModel();
		venue.setVenueId("v_" + String.valueOf(resultSet.getInt("venueId")));
		venue.setVenueName(resultSet.getString("venueName"));
		venue.setVenueType(resultSet.getString("venueType"));
		venue.setVenueDescription(resultSet.getString("venueDesc"));
		venue.setPhotoName("https://partyplanning.s3.ap-south-1.amazonaws.com/" + resultSet.getString("photoName"));
		LOGGER.info("End - venueMapper");
		return venue;

	}
}
