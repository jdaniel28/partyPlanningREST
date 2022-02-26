package com.party.partymangement.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymanagement.util.Util;
import com.party.partymangement.mapper.ScheduleMapper;
import com.party.partymangement.mapper.VenueScheduleMapper;
import com.party.partymangement.model.ScheduleModel;
import com.party.partymangement.model.VenueScheduleModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ScheduleDao.
 */
@Repository
public class ScheduleDao {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(ScheduleDao.class);

	/** The get schedules. */
	private final String GET_SCHEDULES = "select * from schedule as s join  venue as v on s.venueId= v.venueId ;";

	/** The insertschedule. */
	private final String INSERTSCHEDULE = "insert into schedule (venueId,startDate,endDate,facilities,maxCapacity,price) values(?,?,?,?,?,?);";

	/** The selectschedule. */
	private final String SELECTSCHEDULE = "select * from schedule;";

	/** The select schedules by date. */
	private final String SELECT_SCHEDULES_BY_DATE = "select * from schedule as s join  venue as v on s.venueId= v.venueId  where endDate > ?;";

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Insert schedule.
	 *
	 * @param schedule the schedule
	 * @return true, if successful
	 */
	public boolean insertSchedule(ScheduleModel schedule) {
		LOGGER.info("Start - insertSchedule");
		boolean status;
		status = jdbcTemplate.update(INSERTSCHEDULE, Util.convertIdToInt(schedule.getVenueId()),
				schedule.getStartDate(), schedule.getEndDate(), schedule.getFacilities(), schedule.getMaxCapacity(),
				schedule.getPrice()) != 0;
		LOGGER.info("End - insertSchedule");
		return status;
	}

	/**
	 * Gets the all venue schedules.
	 *
	 * @return the all venue schedules
	 */
	public List<VenueScheduleModel> getAllVenueSchedules() {
		LOGGER.info("Inside getAllVenueSchedules");
		return this.jdbcTemplate.query(GET_SCHEDULES, new VenueScheduleMapper());
	}

	/**
	 * Gets the all schedules.
	 *
	 * @return the all schedules
	 */
	public List<ScheduleModel> getAllSchedules() {
		LOGGER.info("Inside getAllSchedules");
		return this.jdbcTemplate.query(SELECTSCHEDULE, new ScheduleMapper());
	}

	/**
	 * Gets the schedules by date.
	 *
	 * @param endDate the end date
	 * @return the schedules by date
	 */
	public List<VenueScheduleModel> getSchedulesByDate(Date endDate) {
		LOGGER.info("Start - getSchedulesByDate");
		List<VenueScheduleModel> schedules = new ArrayList<VenueScheduleModel>();
		try {
			schedules = jdbcTemplate.query(SELECT_SCHEDULES_BY_DATE, new VenueScheduleMapper(), endDate);
		} catch (Exception e) {

		}
		LOGGER.info("End - getSchedulesByDate");
		return schedules;
	}

}
