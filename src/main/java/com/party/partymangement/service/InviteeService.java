package com.party.partymangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.partymangement.dao.InviteeDao;
import com.party.partymangement.model.InviteeDetailsModel;
import com.party.partymangement.model.InviteeModel;

@Service
public class InviteeService {

	@Autowired
	private InviteeDao inviteeDao;

	public boolean addInvitee(InviteeModel invitee) {
		return this.inviteeDao.addInvitee(invitee);
	}

	public List<InviteeModel> getInvitedForBookingId(int bookingId) {
		return this.inviteeDao.getInvitedForBookingId(bookingId);
	}

	public List<InviteeDetailsModel> getAllInviteeDetails(String userId) {
		return this.inviteeDao.getAllInviteeDetails(userId);
	}
}
