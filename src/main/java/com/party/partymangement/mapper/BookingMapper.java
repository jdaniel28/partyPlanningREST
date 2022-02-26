package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.BookingModel;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingMapper.
 */
public class BookingMapper implements RowMapper<BookingModel> {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(BookingMapper.class);

	/**
	 * Map row.
	 *
	 * @param rs     the ResultSet
	 * @param rowNum the row num
	 * @return the booking model
	 * @throws SQLException the SQL exception
	 */
	@Override
	public BookingModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		LOGGER.info("Start - bookingMapper");
		BookingModel booking = new BookingModel();
		booking.setBookingId(rs.getInt("bookingId"));
		booking.setScheduleId("s_" + String.valueOf(rs.getInt("scheduleId")));
		booking.setUserId(rs.getString("userId"));
		LOGGER.info("End - bookingMapper");
		return booking;
	}

}
