package com.party.partymangement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.party.partymangement.model.InviteeDetailsModel;

public class InviteeDetailsMapper implements RowMapper<InviteeDetailsModel> {

	@Override
	public InviteeDetailsModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		InviteeDetailsModel model = new InviteeDetailsModel();
		model.setBookingId(resultSet.getInt("bookingId"));
		model.setContactId(resultSet.getInt("contactId"));
		model.setInviteText(resultSet.getString("inviteText"));
		model.setName(resultSet.getString("name"));
		model.setPhotoName("https://partyplanning.s3.ap-south-1.amazonaws.com/" + resultSet.getString("photoName"));
		return model;
	}

}
