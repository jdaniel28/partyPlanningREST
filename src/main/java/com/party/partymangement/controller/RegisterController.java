package com.party.partymangement.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.party.partymangement.model.RegisterModel;
import com.party.partymangement.service.RegisterService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class RegisterController {

	private final static Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private RegisterService registerService;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody RegisterModel model) {
		LOGGER.debug("Start - login");
		String loginStatus = this.registerService.checkLogin(model);
		if (loginStatus.equals("Password") || loginStatus.equals("UserId")) {
			Map<String, String> message = new HashMap<String, String>();
			message.put("role", loginStatus);
			LOGGER.debug("End - login");
			return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
		} else {
			String role = loginStatus.substring(9, loginStatus.length());
			Map<String, String> message = new HashMap<String, String>();
			message.put("role", role);
			LOGGER.debug("End - login");
			return new ResponseEntity<Object>(message, HttpStatus.OK);
		}
	}

	@PutMapping("/forgotUserId")
	public ResponseEntity<Object> forgotUserId(@RequestBody RegisterModel model) {
		LOGGER.debug("Start - forgotUserId");
		String userId = this.registerService.getUserId(model);
		if (!userId.equals("")) {
			Map<String, String> message = new HashMap<String, String>();
			message.put("userId", userId);
			LOGGER.debug("End - forgotUserId");
			return ResponseEntity.ok(message);
		} else {
			LOGGER.debug("End - forgotUserId");
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/User/{userId}")
	public ResponseEntity<Object> getUser(@PathVariable String userId) {
		LOGGER.debug("Inside getUser");
		return ResponseEntity.ok(registerService.getUser(userId));
	}

	@PutMapping("/UserPassword")
	public ResponseEntity<Object> postPassword(@RequestBody RegisterModel model) {
		LOGGER.debug("Start - postPassword");
		try {
			boolean status = registerService.postUserPassword(model);
			if (!status) {
				throw new Exception();
			}
			LOGGER.debug("End - postPassword");
			return new ResponseEntity<Object>(model, HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.debug("End - postPassword");
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/User")
	public ResponseEntity<Object> postStudent(@RequestBody RegisterModel model) {
		LOGGER.debug("Start - postStudent");
		try {
			boolean status = registerService.postUser(model);
			if (!status) {
				throw new Exception();
			}
			LOGGER.debug("End - postStudent");
			return new ResponseEntity<Object>(model, HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.debug("End - postStudent");
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/forgotPassword")
	public ResponseEntity<Object> forgotPassword(@RequestBody RegisterModel model) {
		LOGGER.debug("Start - forgotPassword");
		boolean status = this.registerService.forgotPassword(model);
		if (status) {
			LOGGER.debug("End - forgotPassword");
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			LOGGER.debug("End - forgotPassword");
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	///////////

	@PutMapping("/uploadPhoto")
	public ResponseEntity<Object> uploadPhotoUser(@RequestParam("photo") MultipartFile file,
			@RequestParam("userId") String userId) {
		LOGGER.debug("Start - uploadPhotoUser");
		boolean status = this.registerService.uploadPhotoUser(file, userId);
		if (status) {
			LOGGER.debug("End - uploadPhotoUser");
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			LOGGER.debug("End - uploadPhotoUser");
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateUser")
	public ResponseEntity<Object> updateUser(@RequestBody RegisterModel model) {
		LOGGER.debug("Start - updateUser");
		boolean status = this.registerService.updateUser(model);
		if (status) {
			LOGGER.debug("End - updateUser");
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			LOGGER.debug("End - updateUser");
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}