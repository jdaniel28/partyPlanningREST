package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.InviteeModel;

public class InviteeMapper implements RowMapper<InviteeModel> {

	@Override
	public InviteeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		InviteeModel invitee = new InviteeModel();
		invitee.setBookingId(rs.getInt("bookingId"));
		invitee.setContactId(rs.getInt("contactId"));
		invitee.setGreetingId("i_" + rs.getString("greetingId"));
		invitee.setInviteeId(rs.getInt("inviteeId"));
		return invitee;
	}

}
