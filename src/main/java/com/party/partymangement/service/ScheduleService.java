package com.party.partymangement.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.partymangement.dao.ScheduleDao;
import com.party.partymangement.dao.VenueDao;
import com.party.partymangement.model.ScheduleModel;
import com.party.partymangement.model.VenueScheduleModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ScheduleService.
 */
@Service
public class ScheduleService {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(ScheduleService.class);

	/** The schedule dao. */
	@Autowired
	private ScheduleDao scheduleDao;

	/** The venue dao. */
	@Autowired
	private VenueDao venueDao;

	/**
	 * Post schedule.
	 *
	 * @param schedule the schedule
	 * @return true, if successful
	 */
	public boolean postSchedule(ScheduleModel schedule) {
		LOGGER.info("Inside postSchedule");
		return scheduleDao.insertSchedule(schedule);
	}

	/**
	 * Gets the all schedules.
	 *
	 * @return the all schedules
	 */
	public List<ScheduleModel> getAllSchedules() {
		LOGGER.info("Inside getAllSchedules");
		return this.scheduleDao.getAllSchedules();
	}

	/**
	 * Gets the all venue schedules.
	 *
	 * @return the all venue schedules
	 */
	public List<VenueScheduleModel> getAllVenueSchedules() {
		LOGGER.info("Inside getAllVenueSchedules");
		return this.scheduleDao.getAllVenueSchedules();
	}

//	public List<VenueScheduleModel> getVenueSchedulesByDate(Date startDate, Date endDate) {
//		List<VenueModel> venues = this.venueDao.getAllVenues();
//		List<ScheduleModel> schedules = this.scheduleDao.getAllSchedules();
//		List<ScheduleModel> actualSchedules = new ArrayList<ScheduleModel>();
//		for (int i = 0; i < schedules.size(); i++) {
//			if (startDate.before(schedules.get(i).getStartDate()) && endDate.after(schedules.get(i).getEndDate())) {
//				actualSchedules.add(schedules.get(i));
//			}
//		}
//		List<VenueScheduleModel> venueSchedules = ScheduleUtil.convertToVenueScheduleList(venues, actualSchedules);
//		return venueSchedules;
//	}

	/**
	 * Gets the schedules by date.
	 *
	 * @param endDate the end date
	 * @return the schedules by date
	 */
	public List<VenueScheduleModel> getSchedulesByDate(Date endDate) {
		LOGGER.info("Inside getSchedulesByDate");
		return this.scheduleDao.getSchedulesByDate(endDate);
	}

}
