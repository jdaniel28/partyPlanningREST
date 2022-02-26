package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.BookingScheduleModel;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingScheduleMapper.
 */
public class BookingScheduleMapper implements RowMapper<BookingScheduleModel> {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(BookingScheduleMapper.class);

	/**
	 * Map row.
	 *
	 * @param resultSet the result set
	 * @param rowNum    the row num
	 * @return the booking schedule model
	 * @throws SQLException the SQL exception
	 */
	@Override
	public BookingScheduleModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		LOGGER.info("Start - bookingScheduleMapper");
		BookingScheduleModel model = new BookingScheduleModel();
		model.setBookingId(resultSet.getInt("bookingId"));
		model.setEndDate(resultSet.getDate("endDate"));
		model.setPrice(resultSet.getDouble("price"));
		model.setScheduleId("s_" + resultSet.getString("scheduleId"));
		model.setStartDate(resultSet.getDate("startDate"));
		model.setUserId(resultSet.getString("userId"));
		LOGGER.info("End - bookingScheduleMapper");
		return model;
	}

}
