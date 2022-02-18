package com.party.partymangement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.party.partymangement.model.VenueModel;
import com.party.partymangement.service.VenueService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class VenueController {

	@Autowired
	private VenueService venueService;
	
	@PostMapping("/Venue")
	public ResponseEntity<Object> postStudent(@RequestBody VenueModel model) {
		try {
			boolean status = venueService.postVenue(model);
			if (!status) {
				throw new Exception();
			}
			return new ResponseEntity<Object>(model, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
