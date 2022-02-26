package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.VenueScheduleModel;

// TODO: Auto-generated Javadoc
/**
 * The Class VenueScheduleMapper.
 */
public class VenueScheduleMapper implements RowMapper<VenueScheduleModel> {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(BookingMapper.class);

	/**
	 * Map row.
	 *
	 * @param resultSet the result set
	 * @param rowNum    the row num
	 * @return the venue schedule model
	 * @throws SQLException the SQL exception
	 */
	@Override
	public VenueScheduleModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		LOGGER.info("Start - venueScheduleMapper");
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
		LOGGER.info("End - venueScheduleMapper");
		return model;
	}

}
