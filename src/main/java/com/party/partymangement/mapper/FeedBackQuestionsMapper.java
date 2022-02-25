package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.FeedBackQuestionsModel;

public class FeedBackQuestionsMapper implements RowMapper<FeedBackQuestionsModel> {

	@Override
	public FeedBackQuestionsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		FeedBackQuestionsModel model = new FeedBackQuestionsModel();
		model.setqId(rs.getInt("qId"));
		model.setQues1(rs.getString("ques1"));
		model.setQues2(rs.getString("ques2"));
		model.setQues3(rs.getString("ques3"));
		return model;
	}

}
