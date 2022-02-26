package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.InviteModel;

// TODO: Auto-generated Javadoc
/**
 * The Class InviteMapper.
 */
public class InviteMapper implements RowMapper<InviteModel> {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(InviteMapper.class);

	/**
	 * Map row.
	 *
	 * @param rs     the rs
	 * @param rowNum the row num
	 * @return the invite model
	 * @throws SQLException the SQL exception
	 */
	@Override
	public InviteModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		LOGGER.info("Start - inviteMapper");
		InviteModel invite = new InviteModel();
		invite.setGreetingId("i_" + String.valueOf(rs.getInt("greetingId")));
		invite.setInviteText(rs.getString("inviteText"));
		invite.setPhotoName("https://partyplanning.s3.ap-south-1.amazonaws.com/" + rs.getString("photoName"));
		LOGGER.info("End - inviteMapper");
		return invite;
	}

}
