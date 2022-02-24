package com.party.partymangement.controller;

import java.util.List;

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

import com.party.partymangement.model.ScheduleModel;
import com.party.partymangement.model.VenueScheduleModel;
import com.party.partymangement.service.ScheduleService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class ScheduleController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ScheduleController.class);

	@Autowired
	private ScheduleService scheduleService;

	@PostMapping("/Schedule")
	public ResponseEntity<Object> postSchedule(@RequestBody ScheduleModel model) {
		LOGGER.debug("Start - postSchedule");
		try {
			boolean status = scheduleService.postSchedule(model);
			if (!status) {
				throw new Exception();
			}
			LOGGER.debug("End - postSchedule");
			return new ResponseEntity<Object>(model, HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.debug("End - postSchedule");
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/Schedules")
	public ResponseEntity<Object> getAllSchedules() {
		LOGGER.debug("Start - getAllSchedules");
		List<ScheduleModel> schedules = this.scheduleService.getAllSchedules();
		LOGGER.debug("End - getAllSchedules");
		return new ResponseEntity<Object>(schedules, HttpStatus.OK);
	}

	@GetMapping("/VenueSchedules")
	public ResponseEntity<Object> getAllVenueSchedules() {
		LOGGER.debug("Start - getAllVenueSchedules");
		List<VenueScheduleModel> venueSchedules = this.scheduleService.getAllVenueSchedules();
		LOGGER.debug("End - getAllVenueSchedules");
		return new ResponseEntity<Object>(venueSchedules, HttpStatus.OK);
	}

	@PostMapping("/VenueSchedules")
	public ResponseEntity<Object> getVenueSchedulesByDate(@RequestBody ScheduleModel schedule) {
		LOGGER.debug("Start - getVenueSchedulesByDate");
		List<VenueScheduleModel> venueSchedules = this.scheduleService.getVenueSchedulesByDate(schedule.getStartDate(),
				schedule.getEndDate());
		LOGGER.debug("End - getVenueSchedulesByDate");
		return new ResponseEntity<Object>(venueSchedules, HttpStatus.OK);
	}

}
