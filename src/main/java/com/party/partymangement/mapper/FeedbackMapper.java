package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.FeedbackModel;

// TODO: Auto-generated Javadoc
/**
 * The Class FeedbackMapper.
 */
public class FeedbackMapper implements RowMapper<FeedbackModel> {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(FeedbackMapper.class);

	/**
	 * Map row.
	 *
	 * @param resultSet the result set
	 * @param i         the i
	 * @return the feedback model
	 * @throws SQLException the SQL exception
	 */
	@Override
	public FeedbackModel mapRow(ResultSet resultSet, int i) throws SQLException {
		LOGGER.info("Start - feedbackMapper");
		FeedbackModel feedback = new FeedbackModel();
		feedback.setFeedbackId(resultSet.getString("feedbackId"));
		feedback.setUserId(resultSet.getString("userId"));
		feedback.setAns1(resultSet.getString("ans1"));
		feedback.setBookingId(resultSet.getInt("bookingId"));
		feedback.setAns2(resultSet.getString("ans2"));
		feedback.setAns3(resultSet.getString("ans3"));
		feedback.setRating(resultSet.getString("rating"));
		feedback.setqId(resultSet.getInt("qId"));
		LOGGER.info("End - feedbackMapper");
		return feedback;

	}
}