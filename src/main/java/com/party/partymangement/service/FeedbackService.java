package com.party.partymangement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.partymangement.dao.FeedbackDao;
import com.party.partymangement.model.FeedBackQuestionsModel;
import com.party.partymangement.model.FeedbackModel;
import com.party.partymangement.model.FeedbackWithQuestionsModel;

// TODO: Auto-generated Javadoc
/**
 * The Class FeedbackService.
 */
@Service
public class FeedbackService {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(FeedbackService.class);

	/** The feedback dao. */
	@Autowired
	private FeedbackDao feedbackDao;

	/**
	 * Post feedback.
	 *
	 * @param feedback the feedback
	 * @return true, if successful
	 */
	public boolean postFeedback(FeedbackModel feedback) {
		LOGGER.info("Inside insertFeedback");
		return feedbackDao.insertFeedback(feedback);
	}

	/**
	 * Gets the all feedback.
	 *
	 * @return the all feedback
	 */
	public List<FeedbackModel> getAllFeedback() {
		LOGGER.info("Inside getAllFeedback");
		return this.feedbackDao.getAllFeedback();
	}

	/**
	 * Gets the feedback questions.
	 *
	 * @return the feedback questions
	 */
	public FeedBackQuestionsModel getFeedbackQuestions() {
		LOGGER.info("Inside getFeedbackQuestions");
		return this.feedbackDao.getFeedbackQuestions();
	}

	/**
	 * Adds the feedback questions.
	 *
	 * @param model the model
	 * @return true, if successful
	 */
	public boolean addFeedbackQuestions(FeedBackQuestionsModel model) {
		LOGGER.info("Inside addFeedbackQuestions");
		return this.feedbackDao.addFeedbackQuestions(model);
	}

	/**
	 * Gets the feedback with questions.
	 *
	 * @return the feedback with questions
	 */
	public List<FeedbackWithQuestionsModel> getFeedbackWithQuestions() {
		LOGGER.info("Inside getFeedbackWithQuestions");
		return this.feedbackDao.getFeedbackWithQuestions();
	}
}
