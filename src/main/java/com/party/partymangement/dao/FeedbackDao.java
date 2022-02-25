package com.party.partymangement.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.FeedBackQuestionsMapper;
import com.party.partymangement.mapper.FeedbackMapper;
import com.party.partymangement.mapper.FeedbackWithQuestionsMapper;
import com.party.partymangement.model.FeedBackQuestionsModel;
import com.party.partymangement.model.FeedbackModel;
import com.party.partymangement.model.FeedbackWithQuestionsModel;

@Repository
public class FeedbackDao {

	private final String VIEW_FEEDBACK = "select * from feedback";
	private final String INSERTFEEDBACK = "insert into feedback(userId,bookingId, ans1,ans2,ans3,rating,qId) values(?,?,?,?,?,?,?);";
	private final String GET_FEEDBACK_QN = "select * from feedbackQuestions where qId =(select max(qId) from feedbackQuestions);";
	private final String ADD_FEEDBACK_QN = "insert into feedbackQuestions (ques1,ques2,ques3) values(?,?,?)";
	private final String GET_FEEDBACK_WITH_QNS = "select * from feedback as f join feedbackQuestions as q on f.qId = q.qId;";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// remove user-id and venueId and add bookingId
	public boolean insertFeedback(FeedbackModel feedback) {
		if (jdbcTemplate.update(INSERTFEEDBACK, feedback.getUserId(), feedback.getBookingId(), feedback.getAns1(),
				feedback.getAns2(), feedback.getAns3(), feedback.getRating(), feedback.getqId()) != 0) {
			return true;
		}
		return false;
	}

	public List<FeedbackModel> getAllFeedback() {
		return this.jdbcTemplate.query(VIEW_FEEDBACK, new FeedbackMapper());
	}

	public FeedBackQuestionsModel getFeedbackQuestions() {
		return this.jdbcTemplate.queryForObject(GET_FEEDBACK_QN, new FeedBackQuestionsMapper());
	}

	public boolean addFeedbackQuestions(FeedBackQuestionsModel model) {
		boolean status;
		try {
			status = this.jdbcTemplate.update(ADD_FEEDBACK_QN, model.getQues1(), model.getQues2(),
					model.getQues3()) != 0;
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	public List<FeedbackWithQuestionsModel> getFeedbackWithQuestions() {
		List<FeedbackWithQuestionsModel> feedback = new ArrayList<FeedbackWithQuestionsModel>();
		try {
			feedback = this.jdbcTemplate.query(GET_FEEDBACK_WITH_QNS, new FeedbackWithQuestionsMapper());
		} catch (Exception e) {
		}
		return feedback;
	}

}
