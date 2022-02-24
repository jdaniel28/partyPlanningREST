package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.FeedbackModel;

public class FeedbackMapper implements RowMapper<FeedbackModel> {
	
	@Override
	public FeedbackModel mapRow(ResultSet resultSet, int i) throws SQLException {
		
		FeedbackModel feedback = new FeedbackModel();
		feedback.setFeedbackId(resultSet.getString("feedbackId"));
		feedback.setUserId(resultSet.getString("userId"));
		feedback.setVenueId(resultSet.getString("venueId"));
		feedback.setAns1(resultSet.getString("ans1"));
		feedback.setAns2(resultSet.getString("ans2"));
		feedback.setAns3(resultSet.getString("ans3"));
		feedback.setRating(resultSet.getString("rating"));
		return feedback;

}
}