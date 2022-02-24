package com.party.partymangement.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymanagement.util.Util;
import com.party.partymangement.mapper.ScheduleMapper;
import com.party.partymangement.mapper.VenueScheduleMapper;
import com.party.partymangement.model.ScheduleModel;
import com.party.partymangement.model.VenueScheduleModel;

@Repository
public class ScheduleDao {

	private final String GET_SCHEDULES = "select * from schedule as s join  venue as v on s.venueId= v.venueId ;";
	private final String INSERTSCHEDULE = "insert into schedule (venueId,startDate,endDate,facilities,maxCapacity,price) values(?,?,?,?,?,?);";
	private final String SELECTSCHEDULE = "select * from schedule;";
	private final String SELECT_SCHEDULES_BY_DATE = "select * from schedule as s join  venue as v on s.venueId= v.venueId  where endDate > ?;";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insertSchedule(ScheduleModel schedule) {
		if (jdbcTemplate.update(INSERTSCHEDULE, Util.convertIdToInt(schedule.getVenueId()), schedule.getStartDate(),
				schedule.getEndDate(), schedule.getFacilities(), schedule.getMaxCapacity(), schedule.getPrice()) != 0) {
			return true;
		}
		return false;
	}

	public List<VenueScheduleModel> getAllVenueSchedules() {
		return this.jdbcTemplate.query(GET_SCHEDULES, new VenueScheduleMapper());
	}

	public List<ScheduleModel> getAllSchedules() {
		return this.jdbcTemplate.query(SELECTSCHEDULE, new ScheduleMapper());
	}

	public List<VenueScheduleModel> getSchedulesByDate(Date endDate) {
		List<VenueScheduleModel> schedules = new ArrayList<VenueScheduleModel>();
		try {
			schedules = jdbcTemplate.query(SELECT_SCHEDULES_BY_DATE, new VenueScheduleMapper(), endDate);
		} catch (Exception e) {

		}
		return schedules;
	}

}
