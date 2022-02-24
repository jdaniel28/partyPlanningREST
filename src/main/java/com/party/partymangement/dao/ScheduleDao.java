package com.party.partymangement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymanagement.util.Util;
import com.party.partymangement.mapper.ScheduleMapper;
import com.party.partymangement.model.ScheduleModel;

@Repository
public class ScheduleDao {

	private final String INSERTSCHEDULE = "insert into schedule (venueId,startDate,endDate,facilities,maxCapacity,price) values(?,?,?,?,?,?);";
	private final String SELECTSCHEDULE = "select * from schedule;";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insertSchedule(ScheduleModel schedule) {
		if (jdbcTemplate.update(INSERTSCHEDULE, Util.convertIdToInt(schedule.getVenueId()), schedule.getStartDate(),
				schedule.getEndDate(), schedule.getFacilities(), schedule.getMaxCapacity(), schedule.getPrice()) != 0) {
			return true;
		}
		return false;
	}

	public List<ScheduleModel> getAllSchedules() {
		return this.jdbcTemplate.query(SELECTSCHEDULE, new ScheduleMapper());
	}

}
