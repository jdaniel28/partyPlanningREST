package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.RegisterModel;

// TODO: Auto-generated Javadoc
/**
 * The Class RegisterMapper.
 */
public class RegisterMapper implements RowMapper<RegisterModel> {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(RegisterMapper.class);

	/**
	 * Map row.
	 *
	 * @param resultSet the result set
	 * @param i         the i
	 * @return the register model
	 * @throws SQLException the SQL exception
	 */
	@Override
	public RegisterModel mapRow(ResultSet resultSet, int i) throws SQLException {
		LOGGER.info("Start - registerMapper");
		RegisterModel register = new RegisterModel();
		register.setFirstName(resultSet.getString("firstName"));
		register.setLastName(resultSet.getString("lastName"));
		register.setDob(resultSet.getDate("dOB"));
		register.setGender(resultSet.getString("gender"));
		register.setUserId(resultSet.getString("userId"));
		register.setContactNumber(resultSet.getString("contactNumber"));
		register.setPassword(resultSet.getString("password"));
		register.setPhotoName("https://partyplanning.s3.ap-south-1.amazonaws.com/" + resultSet.getString("photoName"));
		LOGGER.info("End - registerMapper");
		return register;

	}
}
