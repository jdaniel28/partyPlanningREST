package com.party.partymangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.partymangement.dao.FeedbackDao;
import com.party.partymangement.model.FeedBackQuestionsModel;
import com.party.partymangement.model.FeedbackModel;
import com.party.partymangement.model.FeedbackWithQuestionsModel;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;

	public boolean postFeedback(FeedbackModel feedback) {
		return feedbackDao.insertFeedback(feedback);
	}

	public List<FeedbackModel> getAllFeedback() {
		return this.feedbackDao.getAllFeedback();
	}

	public FeedBackQuestionsModel getFeedbackQuestions() {
		return this.feedbackDao.getFeedbackQuestions();
	}

	public boolean addFeedbackQuestions(FeedBackQuestionsModel model) {
		return this.feedbackDao.addFeedbackQuestions(model);
	}

	public List<FeedbackWithQuestionsModel> getFeedbackWithQuestions() {
		return this.feedbackDao.getFeedbackWithQuestions();
	}
}
