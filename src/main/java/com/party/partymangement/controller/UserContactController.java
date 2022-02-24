package com.party.partymangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.party.partymangement.model.UserContactModel;
import com.party.partymangement.service.UserContactService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class UserContactController {

	@Autowired
	private UserContactService usercontactService;

	@PostMapping("/UserContact")
	public ResponseEntity<Object> postUserContact(@RequestBody UserContactModel model) {
		try {
			boolean status = usercontactService.postUserContact(model);
			if (!status) {
				throw new Exception();
			}
			return new ResponseEntity<Object>(model, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/UserContactList")
	public ResponseEntity<Object> getAllUserContactList() {

		List<UserContactModel> userContact = this.usercontactService.getAllUserContactList();

		return new ResponseEntity(userContact, HttpStatus.OK);
	}

	@PutMapping("/updateUserContact")
	public ResponseEntity<Object> updateUser(@RequestBody UserContactModel userContact) {
		boolean status = this.usercontactService.updateUser(userContact);
		if (status) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteUserContact/{contactId}")
	public ResponseEntity<Object> deleteUserContact(@PathVariable String contactId) {
		boolean status = this.usercontactService.deleteUser(contactId);
		if (status) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

}
