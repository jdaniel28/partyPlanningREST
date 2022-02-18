package com.party.partymangement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.partymangement.dao.VenueDao;

import com.party.partymangement.model.VenueModel;

@Service
public class VenueService {

	
	@Autowired
	private VenueDao venueDao;
	
	public boolean postVenue(VenueModel venue) {
		return venueDao.insertVenue(venue);
	}
}
