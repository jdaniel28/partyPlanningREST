package com.party.partymangement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymangement.mapper.FeedbackMapper;
import com.party.partymangement.model.FeedbackModel;

@Repository
public class FeedbackDao {

	private final String VIEW_FEEDBACK = "select * from feedback";
	private final String INSERTFEEDBACK = "insert into feedback(userId,bookingId, ans1,ans2,ans3,rating) values(?,?,?,?,?,?);";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// remove user-id and venueId and add bookingId
	public boolean insertFeedback(FeedbackModel feedback) {
		if (jdbcTemplate.update(INSERTFEEDBACK, feedback.getUserId(), feedback.getBookingId(), feedback.getAns1(),
				feedback.getAns2(), feedback.getAns3(), feedback.getRating()) != 0) {
			return true;
		}
		return false;
	}

	public List<FeedbackModel> getAllFeedback() {
		return this.jdbcTemplate.query(VIEW_FEEDBACK, new FeedbackMapper());
	}

}
