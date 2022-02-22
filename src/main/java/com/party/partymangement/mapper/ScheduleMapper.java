package com.party.partymangement.mapper;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.party.partymangement.model.RegisterModel;
import com.party.partymangement.model.ScheduleModel;

public class ScheduleMapper implements RowMapper<ScheduleModel> {
	
	@Override
	public ScheduleModel mapRow(ResultSet resultSet, int i) throws SQLException {
		
		ScheduleModel schedule = new ScheduleModel();
		schedule.setVenueId(resultSet.getString("venueId"));
		schedule.setScheduleId(resultSet.getString("scheduleId"));
		schedule.setStartDate(resultSet.getDate("startDate"));
		schedule.setEndDate(resultSet.getDate("endDate"));

		schedule.setFacilities(resultSet.getString("facilities"));
		schedule.setMaxCapacity(resultSet.getInt("maxCapacity"));
		schedule.setPrice(resultSet.getDouble("price"));
		return schedule;
}
}
