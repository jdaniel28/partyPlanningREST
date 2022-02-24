package com.party.partymangement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.party.partymangement.model.FeedbackModel;
import com.party.partymangement.service.FeedbackService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@PostMapping("/UserFeedback")
	public ResponseEntity<Object> postFeedback(@RequestBody FeedbackModel model) {
		try {
			boolean status = feedbackService.postFeedback(model);
			if (!status) {
				throw new Exception();
			}
			return new ResponseEntity<Object>(model, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getFeedback")
	public ResponseEntity<Object> getAllFeedback() {
		return new ResponseEntity<Object>(this.feedbackService.getAllFeedback(), HttpStatus.OK);
	}
}
