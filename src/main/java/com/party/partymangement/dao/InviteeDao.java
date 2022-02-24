package com.party.partymangement.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.party.partymanagement.util.Util;
import com.party.partymangement.mapper.InviteeDetailsMapper;
import com.party.partymangement.mapper.InviteeMapper;
import com.party.partymangement.model.InviteeDetailsModel;
import com.party.partymangement.model.InviteeModel;

@Repository
public class InviteeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String ADD_INVITEE = "insert into invitees(bookingId,contactId,greetingId) values(?,?,?)";
	private static final String GET_INVITED = "select * from invitees where bookingId = ?";
	private static final String GET_INVITEES = "select i.bookingId, i.contactId, g.photoName, g.inviteText, c.name from invitees as i join invitation as g on i.greetingId=g.greetingId join contacts as c on c.contactId= i.contactId where c.userId = ?;";

	public boolean addInvitee(InviteeModel invitee) {
		boolean status;
		try {
			status = this.jdbcTemplate.update(ADD_INVITEE, invitee.getBookingId(), invitee.getContactId(),
					Util.convertIdToInt(invitee.getGreetingId())) != 0;
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	public List<InviteeModel> getInvitedForBookingId(int bookingId) {
		List<InviteeModel> invitees = new ArrayList<InviteeModel>();
		try {
			invitees = this.jdbcTemplate.query(GET_INVITED, new InviteeMapper(), bookingId);
		} catch (Exception e) {
		}
		return invitees;
	}

	public List<InviteeDetailsModel> getAllInviteeDetails(String userId) {
		List<InviteeDetailsModel> invitees = new ArrayList<InviteeDetailsModel>();
		try {
			invitees = this.jdbcTemplate.query(GET_INVITEES, new InviteeDetailsMapper(), userId);
		} catch (Exception e) {

		}
		return invitees;

	}

}
