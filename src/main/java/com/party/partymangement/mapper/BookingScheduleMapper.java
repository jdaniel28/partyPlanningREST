package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.BookingScheduleModel;

public class BookingScheduleMapper implements RowMapper<BookingScheduleModel> {

	@Override
	public BookingScheduleModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		BookingScheduleModel model = new BookingScheduleModel();
		model.setBookingId(resultSet.getInt("bookingId"));
		model.setEndDate(resultSet.getDate("endDate"));
		model.setPrice(resultSet.getDouble("price"));
		model.setScheduleId("s_" + resultSet.getString("scheduleId"));
		model.setStartDate(resultSet.getDate("startDate"));
		model.setUserId(resultSet.getString("userId"));
		return model;
	}

}
