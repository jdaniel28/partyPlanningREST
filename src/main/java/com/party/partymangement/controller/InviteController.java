package com.party.partymangement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.party.partymangement.model.InviteModel;
import com.party.partymangement.service.InviteService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class InviteController {

	@Autowired
	private InviteService inviteService;

	private final static Logger LOGGER = LoggerFactory.getLogger(InviteController.class);

	@PostMapping("/addInvite")
	public ResponseEntity<Object> addInvite(@RequestParam("photo") MultipartFile file,
			@RequestParam("inviteText") String inviteText) {
		LOGGER.info("Start - addInvite");
		InviteModel invite = new InviteModel();
		invite.setInviteText(inviteText);
		boolean status = this.inviteService.addInvite(file, invite);
		if (status) {
			LOGGER.info("End - addInvite");
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} else {
			LOGGER.info("End - addInvite");
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getInvites")
	public ResponseEntity<Object> getAllInvites() {
		LOGGER.info("Inside getAllInvites");
		return new ResponseEntity<Object>(this.inviteService.getAllInvites(), HttpStatus.OK);
	}

}
