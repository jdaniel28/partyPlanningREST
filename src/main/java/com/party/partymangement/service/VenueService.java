package com.party.partymangement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.party.partymanagement.util.Util;
import com.party.partymangement.dao.VenueDao;
import com.party.partymangement.model.VenueModel;

@Service
public class VenueService {

	private final static Logger LOGGER = LoggerFactory.getLogger(VenueService.class);

	@Autowired
	private VenueDao venueDao;

	@Autowired
	private StorageService storageService;

	public boolean postVenue(MultipartFile file, VenueModel venue) {
		LOGGER.debug("Start - postVenue");
		String fileName = file.getOriginalFilename();
		int i;
		for (i = 0; i < fileName.length(); i++) {
			if (fileName.charAt(i) == '.') {
				break;
			}
		}
		String fileExtenstion = fileName.substring(i, fileName.length());
		String actualFileName = "v_";
		int lastId = this.venueDao.getLastId();
		++lastId;
		actualFileName += String.valueOf(lastId) + fileExtenstion;

		venue.setPhotoName(actualFileName);

		boolean status = venueDao.insertVenue(venue);
		this.storageService.uploadFile(file, actualFileName);
		LOGGER.debug("End - postVenue");
		return status;
	}

	public VenueModel getVenue(String venueId) {
		LOGGER.debug("Inside getVenue");
		return this.venueDao.getVenue(Util.convertIdToInt(venueId));
	}

	public List<VenueModel> getAllVenues() {
		LOGGER.debug("Inside getAllVenues");
		return this.venueDao.getAllVenues();
	}
}
