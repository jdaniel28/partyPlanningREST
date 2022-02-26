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

import com.party.partymangement.exception.ResourceNotFoundException;
import com.party.partymangement.model.RegisterModel;
import com.party.partymangement.service.RegisterService;

// TODO: Auto-generated Javadoc
/**
 * The Class RegisterController.
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class RegisterController {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

	/** The register service. */
	@Autowired
	private RegisterService registerService;

	/**
	 * Login.
	 *
	 * @param model the model
	 * @return the response entity
	 */
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody RegisterModel model) {
		LOGGER.info("Start - login");
		String loginStatus = this.registerService.checkLogin(model);
		if (loginStatus.equals("Password") || loginStatus.equals("UserId")) {
			Map<String, String> message = new HashMap<String, String>();
			message.put("role", loginStatus);
			LOGGER.error("End - login");
			return new ResponseEntity<Object>(message, HttpStatus.NOT_FOUND);
		} else {
			String role = loginStatus.substring(9, loginStatus.length());
			Map<String, String> message = new HashMap<String, String>();
			message.put("role", role);
			LOGGER.info("End - login");
			return new ResponseEntity<Object>(message, HttpStatus.OK);
		}
	}

	/**
	 * Forgot user id.
	 *
	 * @param model the model
	 * @return the response entity
	 */
	@PutMapping("/forgotUserId")
	public ResponseEntity<Object> forgotUserId(@RequestBody RegisterModel model) {
		LOGGER.info("Start - forgotUserId");
		String userId = this.registerService.getUserId(model);
		if (!userId.equals("")) {
			Map<String, String> message = new HashMap<String, String>();
			message.put("userId", userId);
			LOGGER.info("End - forgotUserId");
			return ResponseEntity.ok(message);
		} else {
			LOGGER.info("End - forgotUserId");
			throw new ResourceNotFoundException("User ID not found");
//			
		}
	}

	/**
	 * Gets the user.
	 *
	 * @param userId the user id
	 * @return the user
	 */
	@GetMapping("/User/{userId}")
	public ResponseEntity<Object> getUser(@PathVariable String userId) {
		LOGGER.info("Inside getUser");
		return ResponseEntity.ok(registerService.getUser(userId));
	}

	/**
	 * Post password.
	 *
	 * @param model the model
	 * @return the response entity
	 */
	@PutMapping("/UserPassword")
	public ResponseEntity<Object> postPassword(@RequestBody RegisterModel model) {
		LOGGER.info("Start - postPassword");
		try {
			boolean status = registerService.postUserPassword(model);
			if (!status) {
				throw new Exception();
			}
			LOGGER.info("End - postPassword");
			return new ResponseEntity<Object>(model, HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.info("End - postPassword");
			throw new ResourceNotFoundException("Error in Updating Password");
		}
	}

	/**
	 * Post student.
	 *
	 * @param model the model
	 * @return the response entity
	 */
	@PostMapping("/User")
	public ResponseEntity<Object> postUser(@RequestBody RegisterModel model) {
		LOGGER.info("Start - postStudent");
		try {
			boolean status = registerService.postUser(model);
			if (!status) {
				throw new Exception();
			}
			LOGGER.info("End - postStudent");
			return new ResponseEntity<Object>(model, HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.info("End - postStudent");
			throw new ResourceNotFoundException("Error in inserting data to the user");
		}
	}

	/**
	 * Forgot password.
	 *
	 * @param model the model
	 * @return the response entity
	 */
	@PutMapping("/forgotPassword")
	public ResponseEntity<Object> forgotPassword(@RequestBody RegisterModel model) {
		LOGGER.info("Start - forgotPassword");
		boolean status = this.registerService.forgotPassword(model);
		if (status) {
			LOGGER.info("End - forgotPassword");
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			LOGGER.info("End - forgotPassword");
			throw new ResourceNotFoundException("Password doesn't matches with previous data");
		}
	}

	///////////

	/**
	 * Upload photo user.
	 *
	 * @param file   the file
	 * @param userId the user id
	 * @return the response entity
	 */
	@PutMapping("/uploadPhoto")
	public ResponseEntity<Object> uploadPhotoUser(@RequestParam("photo") MultipartFile file,
			@RequestParam("userId") String userId) {
		LOGGER.info("Start - uploadPhotoUser");
		boolean status = this.registerService.uploadPhotoUser(file, userId);
		if (status) {
			LOGGER.info("End - uploadPhotoUser");
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			LOGGER.info("End - uploadPhotoUser");
			throw new ResourceNotFoundException("Error in uploading image");
		}
	}

	/**
	 * Update user.
	 *
	 * @param model the model
	 * @return the response entity
	 */
	@PutMapping("/updateUser")
	public ResponseEntity<Object> updateUser(@RequestBody RegisterModel model) {
		LOGGER.info("Start - updateUser");
		boolean status = this.registerService.updateUser(model);
		if (status) {
			LOGGER.info("End - updateUser");
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			LOGGER.info("End - updateUser");
			throw new ResourceNotFoundException("Error in update user data");
		}
	}
}