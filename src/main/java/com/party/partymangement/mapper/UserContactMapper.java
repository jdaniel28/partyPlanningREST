package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.UserContactModel;

public class UserContactMapper implements RowMapper<UserContactModel> {

	@Override
	public UserContactModel mapRow(ResultSet resultSet, int i) throws SQLException {

		UserContactModel userContact = new UserContactModel();
		userContact.setContactId(resultSet.getInt("contactId"));
		userContact.setUserId(resultSet.getString("userId"));
		userContact.setName(resultSet.getString("name"));
		userContact.setContactNumber(resultSet.getString("contactNumber"));
		userContact.setEmail(resultSet.getString("email"));
		return userContact;

	}
}
