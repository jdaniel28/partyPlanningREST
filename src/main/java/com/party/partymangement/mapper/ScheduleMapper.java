package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.ScheduleModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ScheduleMapper.
 */
public class ScheduleMapper implements RowMapper<ScheduleModel> {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(ScheduleMapper.class);

	/**
	 * Map row.
	 *
	 * @param resultSet the result set
	 * @param i         the i
	 * @return the schedule model
	 * @throws SQLException the SQL exception
	 */
	@Override
	public ScheduleModel mapRow(ResultSet resultSet, int i) throws SQLException {
		LOGGER.info("Start - scheduleMapper");
		ScheduleModel schedule = new ScheduleModel();
		schedule.setVenueId("v_" + String.valueOf(resultSet.getInt("venueId")));
		schedule.setScheduleId("s_" + String.valueOf(resultSet.getInt("scheduleId")));
		schedule.setStartDate(resultSet.getDate("startDate"));
		schedule.setEndDate(resultSet.getDate("endDate"));

		schedule.setFacilities(resultSet.getString("facilities"));
		schedule.setMaxCapacity(resultSet.getInt("maxCapacity"));
		schedule.setPrice(resultSet.getDouble("price"));
		LOGGER.info("End - scheduleMapper");
		return schedule;
	}
}
