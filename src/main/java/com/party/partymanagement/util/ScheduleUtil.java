package com.party.partymanagement.util;

import java.util.ArrayList;
import java.util.List;

import com.party.partymangement.model.ScheduleModel;
import com.party.partymangement.model.VenueModel;
import com.party.partymangement.model.VenueScheduleModel;

public class ScheduleUtil {

	public static List<VenueScheduleModel> convertToVenueScheduleList(List<VenueModel> venuesList,
			List<ScheduleModel> schedulesList) {
		List<VenueScheduleModel> venueSchedules = new ArrayList<VenueScheduleModel>();
		for (int i = 0; i < schedulesList.size(); i++) {
			VenueScheduleModel venueScheduleTemp = new VenueScheduleModel();
			venueScheduleTemp.setVenueId(schedulesList.get(i).getVenueId());
			venueScheduleTemp.setScheduleId(schedulesList.get(i).getScheduleId());
			venueScheduleTemp.setStartDate(schedulesList.get(i).getStartDate());
			venueScheduleTemp.setEndDate(schedulesList.get(i).getEndDate());
			venueScheduleTemp.setFacilities(schedulesList.get(i).getFacilities());
			venueScheduleTemp.setMaxCapacity(schedulesList.get(i).getMaxCapacity());
			venueScheduleTemp.setPrice(schedulesList.get(i).getPrice());

			for (int j = 0; j < venuesList.size(); j++) {
				if (venuesList.get(j).getVenueId().equals(venueScheduleTemp.getVenueId())) {
					venueScheduleTemp.setVenueName(venuesList.get(j).getVenueName());
					venueScheduleTemp.setVenueDescription(venuesList.get(j).getVenueDescription());
					venueScheduleTemp.setVenueType(venuesList.get(j).getVenueType());
					venueScheduleTemp.setPhotoName(venuesList.get(j).getPhotoName());
				}
			}
			venueSchedules.add(venueScheduleTemp);
		}
		return venueSchedules;
	}

}
