package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.InviteModel;

public class InviteMapper implements RowMapper<InviteModel> {

	@Override
	public InviteModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		InviteModel invite = new InviteModel();
		invite.setGreetingId("i_" + String.valueOf(rs.getInt("greetingId")));
		invite.setInviteText(rs.getString("inviteText"));
		invite.setPhotoName("https://partyplanning.s3.ap-south-1.amazonaws.com/" + rs.getString("photoName"));
		return invite;
	}

}
