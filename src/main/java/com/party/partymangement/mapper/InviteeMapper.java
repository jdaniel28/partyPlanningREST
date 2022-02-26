package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.InviteeModel;

// TODO: Auto-generated Javadoc
/**
 * The Class InviteeMapper.
 */
public class InviteeMapper implements RowMapper<InviteeModel> {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(InviteeMapper.class);

	/**
	 * Map row.
	 *
	 * @param rs     the rs
	 * @param rowNum the row num
	 * @return the invitee model
	 * @throws SQLException the SQL exception
	 */
	@Override
	public InviteeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		LOGGER.info("Start - inviteeMapper");
		InviteeModel invitee = new InviteeModel();
		invitee.setBookingId(rs.getInt("bookingId"));
		invitee.setContactId(rs.getInt("contactId"));
		invitee.setGreetingId("i_" + rs.getString("greetingId"));
		invitee.setInviteeId(rs.getInt("inviteeId"));
		LOGGER.info("End - inviteeMapper");
		return invitee;
	}

}
