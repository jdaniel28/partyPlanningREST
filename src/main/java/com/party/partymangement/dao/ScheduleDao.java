package com.party.partymangement.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.RegisterMapper;
import com.party.partymangement.mapper.ScheduleMapper;
import com.party.partymangement.mapper.VenueMapper;
import com.party.partymangement.model.RegisterModel;
import com.party.partymangement.model.ScheduleModel;
import com.party.partymangement.model.VenueModel;

@Repository
public class ScheduleDao {

	
	private final String INSERTSCHEDULE = "insert into schedule (venueId,scheduleId,startDate,endDate,facilities,maxCapacity,price) values(?,?,?,?,?,?,?);";
	private final String SELECTSCHEDULE ="select * from schedule;";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean insertSchedule(ScheduleModel schedule) {
		if (jdbcTemplate.update(INSERTSCHEDULE, schedule.getVenueId(),schedule.getScheduleId(),schedule.getStartDate(),schedule.getEndDate(),schedule.getFacilities(),schedule.getMaxCapacity(),schedule.getPrice()) != 0) {
			return true;
		}
		return false;
	}
	
	public List<ScheduleModel> getAllSchedules() {
		return this.jdbcTemplate.query(SELECTSCHEDULE, new ScheduleMapper());
	}
	
}
