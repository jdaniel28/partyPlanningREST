package com.party.partymangement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.party.partymangement.model.VenueModel;
import com.party.partymangement.service.VenueService;

// TODO: Auto-generated Javadoc
/**
 * The Class VenueController.
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class VenueController {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(VenueController.class);

	/** The venue service. */
	@Autowired
	private VenueService venueService;

	/**
	 * Post venue.
	 *
	 * @param file             the file
	 * @param venueName        the venue name
	 * @param venueType        the venue type
	 * @param venueDescription the venue description
	 * @return the response entity
	 */
	@PostMapping("/Venue")
	public ResponseEntity<Object> postVenue(@RequestParam("photo") MultipartFile file,
			@RequestParam("venueName") String venueName, @RequestParam("venueType") String venueType,
			@RequestParam("venueDescription") String venueDescription) {
		LOGGER.info("Start - postVenue");
		VenueModel model = new VenueModel();
		model.setVenueName(venueName);
		model.setVenueType(venueType);
		model.setVenueDescription(venueDescription);
		try {
			boolean status = venueService.postVenue(file, model);
			if (!status) {
				throw new Exception();
			}
			LOGGER.info("End - postVenue");
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.info("End - postVenue");
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Gets the venue.
	 *
	 * @param venueId the venue id
	 * @return the venue
	 */
	@GetMapping("/Venue/{venueId}")
	public ResponseEntity<Object> getVenue(@PathVariable String venueId) {
		LOGGER.info("Start - getVenue");
		VenueModel venue = this.venueService.getVenue(venueId);
		Map<String, VenueModel> message = new HashMap<String, VenueModel>();
		message.put(venueId, venue);
		LOGGER.info("End - getVenue");
		return new ResponseEntity(message, HttpStatus.OK);
	}

	/**
	 * Gets the all venues.
	 *
	 * @return the all venues
	 */
	@GetMapping("/Venues")
	public ResponseEntity<Object> getAllVenues() {
		LOGGER.info("Start - getAllVenues");
		List<VenueModel> venues = this.venueService.getAllVenues();
		LOGGER.info("End - getAllVenues");
		return new ResponseEntity(venues, HttpStatus.OK);
	}

}
