package com.party.partymangement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.party.partymangement.dao.VenueDao;
import com.party.partymangement.model.VenueModel;
import com.party.partymangement.util.Util;

// TODO: Auto-generated Javadoc
/**
 * The Class VenueService.
 */
@Service
public class VenueService {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(VenueService.class);

	/** The venue dao. */
	@Autowired
	private VenueDao venueDao;

	/** The storage service. */
	@Autowired
	private StorageService storageService;

	/**
	 * Post venue.
	 *
	 * @param file  the file
	 * @param venue the venue
	 * @return true, if successful
	 */
	public boolean postVenue(MultipartFile file, VenueModel venue) {
		LOGGER.info("Start - postVenue");
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
		LOGGER.info("End - postVenue");
		return status;
	}

	/**
	 * Gets the venue.
	 *
	 * @param venueId the venue id
	 * @return the venue
	 */
	public VenueModel getVenue(String venueId) {
		LOGGER.info("Inside getVenue");
		return this.venueDao.getVenue(Util.convertIdToInt(venueId));
	}

	/**
	 * Gets the all venues.
	 *
	 * @return the all venues
	 */
	public List<VenueModel> getAllVenues() {
		LOGGER.info("Inside getAllVenues");
		return this.venueDao.getAllVenues();
	}
}
