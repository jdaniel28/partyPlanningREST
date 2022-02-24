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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.party.partymangement.model.BookingModel;
import com.party.partymangement.model.BookingScheduleModel;
import com.party.partymangement.model.ScheduleModel;
import com.party.partymangement.service.BookingService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class BookingController {

	private final static Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

	@Autowired
	private BookingService bookingService;

	@GetMapping("/tempBookings")
	public ResponseEntity<Object> getAllTempBookings() {
		LOGGER.info("Start - getAllTempBookings");
		List<BookingModel> tempBookings = this.bookingService.getAllTempBookings();
		LOGGER.info("End - getAllTempBookings");
		return new ResponseEntity<Object>(tempBookings, HttpStatus.OK);
	}

	@PostMapping("/addBooking")
	public ResponseEntity<Object> addBooking(@RequestBody BookingModel booking) {
		LOGGER.info("Start - addBooking");
		int id = this.bookingService.addBooking(booking);
		if (id != 0) {
			Map<String, String> message = new HashMap<String, String>();
			message.put("bookingId", String.valueOf(id));
			LOGGER.info("End - addBooking");
			return new ResponseEntity<Object>(message, HttpStatus.CREATED);
		}
		LOGGER.info("End - addBooking");
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/approveBooking")
	public ResponseEntity<Object> approveBooking(@RequestBody BookingModel booking) {
		LOGGER.info("Start - approveBookings");
		if (this.bookingService.approveBooking(booking)) {
			LOGGER.info("End - approveBookings");
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		}
		LOGGER.info("End - approveBookings");
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/confirmedBookings")
	public ResponseEntity<Object> getAllConfirmedBookings() {
		LOGGER.info("Start - getAllConfirmedBookings");
		List<BookingModel> tempBookings = this.bookingService.getAllConfirmedBookings();
		LOGGER.info("End - getAllConfirmedBookings");
		return new ResponseEntity<Object>(tempBookings, HttpStatus.OK);
	}

	@GetMapping("/getBookingSchedules")
	public ResponseEntity<Object> getAllBookingSchedules() {
		List<BookingScheduleModel> bookingSchedules = this.bookingService.getAllBookingSchedules();
		return new ResponseEntity<Object>(bookingSchedules, HttpStatus.OK);
	}

	@PostMapping("/bookingSchedules")
	public ResponseEntity<Object> getBookingSchedulesByDate(@RequestBody ScheduleModel model) {
		List<BookingScheduleModel> bookingSchedules = this.bookingService.getAllBookingSchedulesByDate(model);
		if (bookingSchedules.size() != 0) {
			return new ResponseEntity<Object>(bookingSchedules, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

}
