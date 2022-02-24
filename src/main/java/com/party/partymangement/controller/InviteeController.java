package com.party.partymangement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.party.partymangement.model.InviteeDetailsModel;
import com.party.partymangement.model.InviteeModel;
import com.party.partymangement.service.InviteeService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class InviteeController {

	@Autowired
	private InviteeService inviteeService;

	@PostMapping("/addInvitee")
	public ResponseEntity<Object> addInvitee(@RequestBody InviteeModel invitee) {
		boolean status = this.inviteeService.addInvitee(invitee);
		if (status) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getInvitees/{bookingId}")
	public ResponseEntity<Object> getInviteesByBookingId(@PathVariable int bookingId) {
		List<InviteeModel> invitees = new ArrayList<InviteeModel>();
		invitees = this.inviteeService.getInvitedForBookingId(bookingId);
		if (invitees.size() != 0) {
			return new ResponseEntity<Object>(invitees, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getInviteeDetails/{userId}")
	public ResponseEntity<Object> getAllInviteeDetails(@PathVariable String userId) {
		List<InviteeDetailsModel> invitees = this.inviteeService.getAllInviteeDetails(userId);
		if (invitees.size() != 0) {
			return new ResponseEntity<Object>(invitees, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
