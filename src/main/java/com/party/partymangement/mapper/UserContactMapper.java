package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.UserContactModel;

public class UserContactMapper implements RowMapper<UserContactModel> {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserContactMapper.class);

	@Override
	public UserContactModel mapRow(ResultSet resultSet, int i) throws SQLException {
		LOGGER.info("Start - userContactMapper");
		UserContactModel userContact = new UserContactModel();
		userContact.setContactId(resultSet.getInt("contactId"));
		userContact.setUserId(resultSet.getString("userId"));
		userContact.setName(resultSet.getString("name"));
		userContact.setContactNumber(resultSet.getString("contactNumber"));
		userContact.setEmail(resultSet.getString("email"));
		LOGGER.info("End - userContactMapper");
		return userContact;

	}
}
