package com.party.partymangement.controller;

import java.util.Date;
import java.util.List;

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

	@Autowired
	private ScheduleService scheduleService;

	@PostMapping("/Schedule")
	public ResponseEntity<Object> postSchedule(@RequestBody ScheduleModel model) {
		try {
			boolean status = scheduleService.postSchedule(model);
			if (!status) {
				throw new Exception();
			}
			return new ResponseEntity<Object>(model, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

//	@GetMapping("/Schedule")
//	public ResponseEntity<Object> getAllSchedules() {
//		return ResponseEntity.ok(scheduleService.getAllSchedules());
//	}

	@GetMapping("/Schedules")
	public ResponseEntity<Object> getAllSchedules() {

		List<ScheduleModel> schedules = this.scheduleService.getAllSchedules();

		return new ResponseEntity(schedules, HttpStatus.OK);
	}

	@GetMapping("/VenueSchedules")
	public ResponseEntity<Object> getAllVenueSchedules() {
		List<VenueScheduleModel> venueSchedules = this.scheduleService.getAllVenueSchedules();
		return new ResponseEntity(venueSchedules, HttpStatus.OK);
	}

	@PostMapping("/VenueSchedules")
	public ResponseEntity<Object> getVenueSchedulesByDate(@RequestBody Date startDate, @RequestBody Date endDate) {
		List<VenueScheduleModel> venueSchedules = this.scheduleService.getVenueSchedulesByDate(startDate, endDate);
		return new ResponseEntity(venueSchedules, HttpStatus.OK);
	}

}
