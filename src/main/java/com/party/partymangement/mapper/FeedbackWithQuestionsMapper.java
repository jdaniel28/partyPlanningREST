package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.FeedbackWithQuestionsModel;

public class FeedbackWithQuestionsMapper implements RowMapper<FeedbackWithQuestionsModel> {

	private final static Logger LOGGER = LoggerFactory.getLogger(FeedbackWithQuestionsMapper.class);

	@Override
	public FeedbackWithQuestionsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		LOGGER.info("Start - feedbackWithQuestionsMapper");
		FeedbackWithQuestionsModel model = new FeedbackWithQuestionsModel();
		model.setAns1(rs.getString("ans1"));
		model.setAns2(rs.getString("ans2"));
		model.setAns3(rs.getString("ans3"));
		model.setBookingId(rs.getInt("bookingId"));
		model.setFeedbackId(rs.getString("feedbackId"));
		model.setqId(rs.getInt("qId"));
		model.setQues1(rs.getString("ques1"));
		model.setQues2(rs.getString("ques2"));
		model.setQues3(rs.getString("ques3"));
		model.setRating(rs.getString("rating"));
		model.setUserId(rs.getString("userId"));
		LOGGER.info("End - feedbackWithQuestionsMapper");
		return model;
	}

}
