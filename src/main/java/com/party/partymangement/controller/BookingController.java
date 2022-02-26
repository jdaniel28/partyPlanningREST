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

import com.party.partymangement.exception.ResourceNotFoundException;
import com.party.partymangement.model.BookingModel;
import com.party.partymangement.model.BookingScheduleModel;
import com.party.partymangement.model.ScheduleModel;
import com.party.partymangement.service.BookingService;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingController.
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class BookingController {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

	/** The booking service. */
	@Autowired
	private BookingService bookingService;

	/**
	 * Gets the all temp bookings.
	 *
	 * @return the all temp bookings
	 */
	@GetMapping("/tempBookings")
	public ResponseEntity<Object> getAllTempBookings() {
		LOGGER.info("Start - getAllTempBookings");
		List<BookingModel> tempBookings = this.bookingService.getAllTempBookings();
		LOGGER.info("End - getAllTempBookings");
		return new ResponseEntity<Object>(tempBookings, HttpStatus.OK);
	}

	/**
	 * Adds the booking.
	 *
	 * @param booking the booking
	 * @return the response entity
	 */
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
		LOGGER.error("Failed to add booking - addBooking");
		throw new ResourceNotFoundException("Failed to add booking");
	}

	/**
	 * Approve booking.
	 *
	 * @param booking the booking
	 * @return the response entity
	 */
	@PostMapping("/approveBooking")
	public ResponseEntity<Object> approveBooking(@RequestBody BookingModel booking) {
		LOGGER.info("Start - approveBookings");
		if (this.bookingService.approveBooking(booking)) {
			LOGGER.info("End - approveBookings");
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		}
		LOGGER.info("End - approveBookings");
		throw new ResourceNotFoundException("Failed to approve the booking status");
	}

	/**
	 * Gets the all confirmed bookings.
	 *
	 * @return the all confirmed bookings
	 */
	@GetMapping("/confirmedBookings")
	public ResponseEntity<Object> getAllConfirmedBookings() {
		LOGGER.info("Start - getAllConfirmedBookings");
		List<BookingModel> tempBookings = this.bookingService.getAllConfirmedBookings();
		LOGGER.info("End - getAllConfirmedBookings");
		return new ResponseEntity<Object>(tempBookings, HttpStatus.OK);
	}

	/**
	 * Gets the all booking schedules.
	 *
	 * @return the all booking schedules
	 */
	@GetMapping("/getBookingSchedules")
	public ResponseEntity<Object> getAllBookingSchedules() {
		List<BookingScheduleModel> bookingSchedules = this.bookingService.getAllBookingSchedules();
		return new ResponseEntity<Object>(bookingSchedules, HttpStatus.OK);
	}

	/**
	 * Gets the booking schedules by date.
	 *
	 * @param model the model
	 * @return the booking schedules by date
	 */
	@PostMapping("/bookingSchedules")
	public ResponseEntity<Object> getBookingSchedulesByDate(@RequestBody ScheduleModel model) {
		List<BookingScheduleModel> bookingSchedules = this.bookingService.getAllBookingSchedulesByDate(model);
		if (bookingSchedules.size() != 0) {
			return new ResponseEntity<Object>(bookingSchedules, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Failed to book the schedule for the veneue");
		}
	}

}
