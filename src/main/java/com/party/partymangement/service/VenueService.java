package com.party.partymangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.party.partymangement.dao.VenueDao;
import com.party.partymangement.model.VenueModel;

@Service
public class VenueService {

	@Autowired
	private VenueDao venueDao;

	@Autowired
	private StorageService storageService;

	public boolean postVenue(MultipartFile file, VenueModel venue) {

		String fileName = file.getOriginalFilename();
		int i;
		for (i = 0; i < fileName.length(); i++) {
			if (fileName.charAt(i) == '.') {
				break;
			}
		}
		String fileExtenstion = fileName.substring(i, fileName.length());
		String actualFileName = "v_" + venue.getVenueId() + fileExtenstion;

		venue.setPhotoName(actualFileName);

		boolean status = venueDao.insertVenue(venue);
		this.storageService.uploadFile(file, actualFileName);

		return status;
	}

	public VenueModel getVenue(String venueId) {
		return this.venueDao.getVenue(venueId);
	}

	public List<VenueModel> getAllVenues() {
		return this.venueDao.getAllVenues();
	}
}
