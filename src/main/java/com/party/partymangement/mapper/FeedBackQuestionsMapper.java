package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.FeedBackQuestionsModel;

// TODO: Auto-generated Javadoc
/**
 * The Class FeedBackQuestionsMapper.
 */
public class FeedBackQuestionsMapper implements RowMapper<FeedBackQuestionsModel> {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(FeedBackQuestionsMapper.class);

	/**
	 * Map row.
	 *
	 * @param rs     the rs
	 * @param rowNum the row num
	 * @return the feed back questions model
	 * @throws SQLException the SQL exception
	 */
	@Override
	public FeedBackQuestionsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		LOGGER.info("Start - feedbackQuestionsMapper");
		FeedBackQuestionsModel model = new FeedBackQuestionsModel();
		model.setqId(rs.getInt("qId"));
		model.setQues1(rs.getString("ques1"));
		model.setQues2(rs.getString("ques2"));
		model.setQues3(rs.getString("ques3"));
		LOGGER.info("End - feedbackQuestionsMapper");
		return model;
	}

}
