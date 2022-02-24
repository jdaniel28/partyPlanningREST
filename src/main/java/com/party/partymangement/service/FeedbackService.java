package com.party.partymangement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.partymangement.dao.FeedbackDao;
import com.party.partymangement.dao.VenueDao;
import com.party.partymangement.model.FeedbackModel;
import com.party.partymangement.model.VenueModel;

@Service
public class FeedbackService {

	
	@Autowired
	private FeedbackDao feedbackDao;
	
	public boolean postFeedback(FeedbackModel feedback) {
		return feedbackDao.insertFeedback(feedback);
	}
}
