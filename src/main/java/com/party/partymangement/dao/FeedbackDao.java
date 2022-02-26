package com.party.partymangement.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.FeedBackQuestionsMapper;
import com.party.partymangement.mapper.FeedbackMapper;
import com.party.partymangement.mapper.FeedbackWithQuestionsMapper;
import com.party.partymangement.model.FeedBackQuestionsModel;
import com.party.partymangement.model.FeedbackModel;
import com.party.partymangement.model.FeedbackWithQuestionsModel;

// TODO: Auto-generated Javadoc
/**
 * The Class FeedbackDao.
 */
@Repository
public class FeedbackDao {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(FeedbackDao.class);

	/** The view feedback. */
	private final String VIEW_FEEDBACK = "select * from feedback";

	/** The insertfeedback. */
	private final String INSERTFEEDBACK = "insert into feedback(userId,bookingId, ans1,ans2,ans3,rating,qId) values(?,?,?,?,?,?,?);";

	/** The get feedback qn. */
	private final String GET_FEEDBACK_QN = "select * from feedbackQuestions where qId =(select max(qId) from feedbackQuestions);";

	/** The add feedback qn. */
	private final String ADD_FEEDBACK_QN = "insert into feedbackQuestions (ques1,ques2,ques3) values(?,?,?)";

	/** The get feedback with qns. */
	private final String GET_FEEDBACK_WITH_QNS = "select * from feedback as f join feedbackQuestions as q on f.qId = q.qId;";

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Insert feedback.
	 *
	 * @param feedback the feedback
	 * @return true, if successful
	 */
	// remove user-id and venueId and add bookingId
	public boolean insertFeedback(FeedbackModel feedback) {
		LOGGER.info("Start - insertFeedback");
		boolean status;
		status = jdbcTemplate.update(INSERTFEEDBACK, feedback.getUserId(), feedback.getBookingId(), feedback.getAns1(),
				feedback.getAns2(), feedback.getAns3(), feedback.getRating(), feedback.getqId()) != 0;
		LOGGER.info("End - insertFeedback");
		return status;
	}

	/**
	 * Gets the all feedback.
	 *
	 * @return the all feedback
	 */
	public List<FeedbackModel> getAllFeedback() {
		LOGGER.info("Inside getAllFeedback");
		return this.jdbcTemplate.query(VIEW_FEEDBACK, new FeedbackMapper());
	}

	/**
	 * Gets the feedback questions.
	 *
	 * @return the feedback questions
	 */
	public FeedBackQuestionsModel getFeedbackQuestions() {
		LOGGER.info("Inside getFeedbackQuestions");
		return this.jdbcTemplate.queryForObject(GET_FEEDBACK_QN, new FeedBackQuestionsMapper());
	}

	/**
	 * Adds the feedback questions.
	 *
	 * @param model the model
	 * @return true, if successful
	 */
	public boolean addFeedbackQuestions(FeedBackQuestionsModel model) {
		LOGGER.info("Start - addFeedbackQuestions");
		boolean status;
		try {
			status = this.jdbcTemplate.update(ADD_FEEDBACK_QN, model.getQues1(), model.getQues2(),
					model.getQues3()) != 0;
		} catch (Exception e) {
			status = false;
		}
		LOGGER.info("End - addFeedbackQuestions");
		return status;
	}

	/**
	 * Gets the feedback with questions.
	 *
	 * @return the feedback with questions
	 */
	public List<FeedbackWithQuestionsModel> getFeedbackWithQuestions() {
		LOGGER.info("Start - getFeedbackWithQuestions");
		List<FeedbackWithQuestionsModel> feedback = new ArrayList<FeedbackWithQuestionsModel>();
		try {
			feedback = this.jdbcTemplate.query(GET_FEEDBACK_WITH_QNS, new FeedbackWithQuestionsMapper());
		} catch (Exception e) {
		}
		LOGGER.info("End - getFeedbackWithQuestions");
		return feedback;
	}

}
