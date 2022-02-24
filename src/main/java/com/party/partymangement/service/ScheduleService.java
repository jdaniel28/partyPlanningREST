package com.party.partymangement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.partymangement.dao.ScheduleDao;
import com.party.partymangement.dao.VenueDao;
import com.party.partymangement.model.ScheduleModel;
import com.party.partymangement.model.VenueScheduleModel;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleDao scheduleDao;

	@Autowired
	private VenueDao venueDao;

	public boolean postSchedule(ScheduleModel schedule) {
		return scheduleDao.insertSchedule(schedule);
	}

	public List<ScheduleModel> getAllSchedules() {
		return this.scheduleDao.getAllSchedules();
	}

	public List<VenueScheduleModel> getAllVenueSchedules() {
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

	public List<VenueScheduleModel> getSchedulesByDate(Date endDate) {
		return this.scheduleDao.getSchedulesByDate(endDate);
	}

}
