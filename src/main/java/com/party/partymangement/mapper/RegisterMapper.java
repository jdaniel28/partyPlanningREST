package com.party.partymangement.mapper;

import java.util.Date;
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
		register.setDob(new Date(resultSet.getDate("dOB").getTime()));
		register.setGender(resultSet.getString("gender"));
		register.setUserId(resultSet.getString("userId"));
		register.setContactNumber(resultSet.getString("contactNumber"));
		register.setPassword(resultSet.getString("password"));
		return register;

}
}
