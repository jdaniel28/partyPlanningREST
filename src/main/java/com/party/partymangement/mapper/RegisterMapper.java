package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.RegisterModel;

public class RegisterMapper implements RowMapper<RegisterModel> {

	@Override
	public RegisterModel mapRow(ResultSet resultSet, int i) throws SQLException {

		RegisterModel register = new RegisterModel();
		register.setFirstName(resultSet.getString("firstName"));
		register.setLastName(resultSet.getString("lastName"));
		register.setDob(resultSet.getDate("dOB"));
		register.setGender(resultSet.getString("gender"));
		register.setUserId(resultSet.getString("userId"));
		register.setContactNumber(resultSet.getString("contactNumber"));
		register.setPassword(resultSet.getString("password"));
//		register.setAns1(resultSet.getString("ans1"));
//		register.setAns2(resultSet.getString("ans2"));
//		register.setAns3(resultSet.getString("ans3"));
		register.setPhotoName("https://partyplanning.s3.ap-south-1.amazonaws.com/" + resultSet.getString("photoName"));
		return register;

	}
}
