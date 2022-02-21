package com.party.partymangement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class VenueController {

	@Autowired
	private VenueService venueService;

	@PostMapping("/Venue")
	public ResponseEntity<Object> postVenue(@RequestParam("photo") MultipartFile file,
			@RequestParam("venueId") String venueId, @RequestParam("venueName") String venueName,
			@RequestParam("venueType") String venueType, @RequestParam("venueDescription") String venueDescription) {
		VenueModel model = new VenueModel();
		model.setVenueId(venueId);
		model.setVenueName(venueName);
		model.setVenueType(venueType);
		model.setVenueDescription(venueDescription);
		try {
			boolean status = venueService.postVenue(file, model);
			if (!status) {
				throw new Exception();
			}
			return new ResponseEntity<Object>(model, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/Venue/{venueId}")
	public ResponseEntity<Object> getVenue(@PathVariable String venueId) {
		VenueModel venue = this.venueService.getVenue(venueId);
		Map<String, VenueModel> message = new HashMap<String, VenueModel>();
		message.put(venueId, venue);
		return new ResponseEntity(message, HttpStatus.OK);
	}

	@GetMapping("/Venues")
	public ResponseEntity<Object> getAllVenues() {

		List<VenueModel> venues = this.venueService.getAllVenues();

		return new ResponseEntity(venues, HttpStatus.OK);
	}

}
