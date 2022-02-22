package com.party.partymangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.party.partymangement.model.BookingModel;
import com.party.partymangement.service.BookingService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@GetMapping("/tempBookings")
	public ResponseEntity<Object> getAllTempBookings() {
		List<BookingModel> tempBookings = this.bookingService.getAllTempBookings();
		return new ResponseEntity<Object>(tempBookings, HttpStatus.OK);
	}

	@PostMapping("/addBooking")
	public ResponseEntity<Object> addBooking(@RequestBody BookingModel booking) {
		if (this.bookingService.addBooking(booking)) {
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/approveBooking")
	public ResponseEntity<Object> approveBooking(@RequestBody BookingModel booking) {
		if (this.bookingService.approveBooking(booking)) {
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

}
