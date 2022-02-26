package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.InviteeDetailsModel;

// TODO: Auto-generated Javadoc
/**
 * The Class InviteeDetailsMapper.
 */
public class InviteeDetailsMapper implements RowMapper<InviteeDetailsModel> {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(InviteeDetailsMapper.class);

	/**
	 * Map row.
	 *
	 * @param resultSet the result set
	 * @param rowNum    the row num
	 * @return the invitee details model
	 * @throws SQLException the SQL exception
	 */
	@Override
	public InviteeDetailsModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		LOGGER.info("Start - inviteeDetailsMapper");
		InviteeDetailsModel model = new InviteeDetailsModel();
		model.setBookingId(resultSet.getInt("bookingId"));
		model.setContactId(resultSet.getInt("contactId"));
		model.setInviteText(resultSet.getString("inviteText"));
		model.setName(resultSet.getString("name"));
		model.setPhotoName("https://partyplanning.s3.ap-south-1.amazonaws.com/" + resultSet.getString("photoName"));
		LOGGER.info("End - inviteeDetailsMapper");
		return model;
	}

}
