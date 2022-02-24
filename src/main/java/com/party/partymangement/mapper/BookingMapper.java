package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.BookingModel;

public class BookingMapper implements RowMapper<BookingModel> {

	@Override
	public BookingModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookingModel booking = new BookingModel();
		booking.setBookingId(rs.getInt("bookingId"));
		booking.setInviteId(rs.getString("inviteId"));
		booking.setScheduleId("s_" + String.valueOf(rs.getInt("scheduleId")));
		booking.setUserId(rs.getString("userId"));
		return booking;
	}

}
